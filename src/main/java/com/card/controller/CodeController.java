package com.vipCardProject.spring.web.controller;

import com.vipCardProject.spring.web.entity.Code;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by 69027 on 2017/10/18.
 */
@Controller
public class CodeController {
    @RequestMapping("/getCode")
    public String getCode(HttpServletRequest request){
        long c=System.currentTimeMillis();
        String s=String.valueOf(c);
        String code=s.substring(s.length()-4,s.length());

        Jedis jedis = new Jedis("39.106.35.242",6379);
        jedis.set("code",code);
        jedis.expire("code",60);
        jedis.close();

        SendMessage.sendMessage(request.getParameter("phoneNumber"),code);

        return "Redister.jsp";



    }
}
