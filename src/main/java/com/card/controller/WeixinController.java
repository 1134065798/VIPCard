package com.card.controller;

import com.card.service.IUserService;
import com.card.util.CheckSignatureUtil;
import com.card.util.GetOpenIdUtil;
import com.card.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.security.DigestException;

/**
 * Created by 1021 on 2017/10/25.
 */

@Controller
public class WeixinController {

    private String token= PropertyUtil.getValue_String("weixin.token");
    public WeixinController() {

        this.token = token;
    }
    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/weixin")
    public String checkSignature(@RequestParam String signature, @RequestParam String timestamp,
                                 @RequestParam String nonce, @RequestParam String echostr) {

        //字典排序
        String sortString = CheckSignatureUtil.dictionarySort(token, timestamp, nonce);

        System.out.println(echostr);

        try {
            //加密
            String mytoken = CheckSignatureUtil.SHA1(sortString);
            // 校验签名
            if (mytoken.equals(signature)) {
                return echostr;
            }
        } catch (DigestException e) {
            System.out.println("加密失败");
        }
        return null;
    }

    @RequestMapping("/redirect")
    public void redirect(HttpServletResponse response) throws Exception {
        response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxdb9a99feced63612&redirect_uri=http%3a%2f%2fweixin.ppplans.com%2fmy%2fgetOpenId&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");

    }

    @RequestMapping("/getOpenId")
    public String login(@RequestParam(value = "code") String code) throws Exception {

        String openId = GetOpenIdUtil.getOpenid(code);
        boolean bool=userService.loadById(openId);
        return bool?"redirect:regist?openId=openId":"info?openId=openId";
    }

}

