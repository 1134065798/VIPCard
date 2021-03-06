package com.card.controller;

import com.alibaba.fastjson.JSON;
import com.card.entity.AddTwo;
import com.card.entity.User;
import com.card.entity.VipCard;
import com.card.entity.qrCode;
import com.card.service.IUserService;
import com.card.service.IVipCardService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ypj on 2017/10/27.
 */
@Controller
 public class UsersController {
    private static final Logger log = Logger.getLogger(UsersController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private IVipCardService vipCardService;

    @ResponseBody
    @RequestMapping(value="/usersController",produces = "text/html;charset=UTF-8")
    public String loadAll(@RequestParam("jsonCallBack")String jsonCallBack,
                          @RequestParam("openId")String openId) {

        //String openId = "00000100000200000300000400000501";
        log.info("个人信息控制器");

        User user = userService.loadUserByopenId(openId);
        VipCard qrCode = vipCardService.loadqrCodeByopenId(openId);
        AddTwo addTwo = new AddTwo();
        addTwo.setUser(user);
        addTwo.setVipCard(qrCode);
        String json =jsonCallBack+"("+JSON.toJSON(addTwo)+")";
        return json;
    }

    @ResponseBody
    @RequestMapping(value="/qrCodeController",produces = "text/html;charset=UTF-8")
    public String qrCode(@RequestParam("jsonCallBack")String jsonCallBack,
                         @RequestParam("openId")String openId){

        log.info("二维码信息控制器");

        String cardId=vipCardService.findCardIdByOpenId(openId);
        User user = userService.loadUserByopenId(openId);
        qrCode qrcode = new qrCode();
        qrcode.setUser(user);
        qrcode.setCardId(cardId);
        String qrCodeJson =jsonCallBack+"("+JSON.toJSON(qrcode)+")";
        return qrCodeJson;
    }

}
