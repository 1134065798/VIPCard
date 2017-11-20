package com.card.controller;

import com.alibaba.fastjson.JSON;
import com.card.entity.Card;
import com.card.entity.User;
import com.card.entity.VipCard;
import com.card.service.ICardService;
import com.card.service.IUserService;
import com.card.service.IVipCardService;
import com.card.util.QRCodeUtil;
import com.card.util.TimeUtil;
import com.google.zxing.WriterException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
	private static final Logger log=Logger.getLogger(UserController.class);

	@Autowired
	private IUserService userService;
	@Autowired
	private IVipCardService vipCardService;
	@Autowired
	private ICardService cardService;

	@ResponseBody
	@RequestMapping("/loadAll")
	public String loadAll() {
		List<User> List=userService.loadAll();
		return List.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/register",produces = "text/html;charset=UTF-8")
	public String register(@RequestParam("openId")String openId,
						   @RequestParam("phone")String phone,
						   @RequestParam("userMajor")String userMajor,
						   @RequestParam("userName")String userName,
						   @RequestParam("userPhoto")String userPhoto,
						   @RequestParam("userSchool")String userSchool,
						   @RequestParam("userSex")String userSex,
						   @RequestParam("activeCode")String activeCode,
						   @RequestParam("verifCode")String verifCode,
						   @RequestParam("jsonCallBack")String jsonCallBack
						   ) throws IOException, WriterException {
		log.info("进入注册控制器");

		String errmsg=null;
		String error="0";

		QRCodeUtil qrCodeUtil=new QRCodeUtil();

		Jedis jedis=new Jedis("47.95.222.74",6379);
		String code=jedis.get(phone);
		jedis.close();

		Card card=cardService.findCard(activeCode);

		if(code==null){
			errmsg="验证码失效";
			log.error("验证码失效");
		}else if (code.equals(verifCode) == false) {
			errmsg = "验证码错误";
			log.error("验证码错误");
		}else if (card == null) {
			errmsg = "激活码错误";
			log.error("激活码错误");
		}else {
			User user = new User(openId, phone, userName, userSex, userSchool, userMajor, userPhoto);
			VipCard vipCard = new VipCard();
			vipCard.setCardId(card.getCardId());
			vipCard.setOpenId(user.getOpenId());
			vipCard.setCreateTime(TimeUtil.getCreateTime());
			vipCard.setQrCode(qrCodeUtil.generateQRCode(user.getOpenId()));

			log.info("保存用户信息");

			vipCardService.saveVipCard(vipCard);
			cardService.delectCard(card.getCardId());
			userService.saveUser(user);

			error = "1";
		}
		Map<String,String> map=new HashMap<String, String>();
		map.put("error",error);
		map.put("errmsg",errmsg);

		return jsonCallBack+"("+JSON.toJSONString(map)+")";
	}

}
