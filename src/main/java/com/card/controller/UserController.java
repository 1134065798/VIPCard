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
						   @RequestParam("verifCode")String verifCode
						   ) throws IOException, WriterException {

		//register?openId=2&phone=3&userMajor=3&userName=3&userPhoto=3&userSchool=3&userSex=3&activeCode=3&verifCode=
		//http://localhost:8080/VIPCard/register?openId=1&phone=10&userName=%E5%BC%A0%E4%B8%89&userSex=%E7%94%B7&userSchool=%E8%A5%BF%E7%A7%91%E5%A4%A7&userMajor=%E5%B7%A5%E4%B8%9A&userPhoto=test&activeCode=3
		String errmsg=null;
		String error="0";

		QRCodeUtil qrCodeUtil=new QRCodeUtil();

//		Jedis jedis=new Jedis("47.95.222.74",6379);
//		String code=jedis.get(phone);
//		jedis.close();
		String code="3";

		Card card=cardService.findCard(activeCode);

		if(code==null){
			errmsg="验证码失效";
		}else if (code.equals(verifCode) == false) {
			errmsg = "验证码错误";
		}else if (card == null) {
			errmsg = "激活码错误";
		}else {
			User user = new User(openId, phone, userName, userSex, userSchool, userMajor, userPhoto);
			VipCard vipCard = new VipCard();
			vipCard.setCardId(card.getCardId());
			vipCard.setOpenId(user.getOpenId());
			vipCard.setCreateTime(TimeUtil.getCreateTime());
			//vipCard.setQrCode(qrCodeUtil.generateQRCode(user.getOpenId()));
			vipCard.setQrCode("1");

			vipCardService.saveVipCard(vipCard);
			cardService.delectCard(card.getCardId());
			userService.saveUser(user);

			error = "1";
		}
		Map<String,String> map=new HashMap<String, String>();
		map.put("error",error);
		map.put("errmsg",errmsg);

		return JSON.toJSONString(map);
	}

}
