package com.card.controller;

import com.alibaba.fastjson.JSON;
import com.card.util.QRCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ypj on 2017/11/29.
 */
@Controller
public class UptokenController {
    @ResponseBody
    @RequestMapping("/getUptoken")
    public String getUptoken(@RequestParam("jsonCallBack")String jsonCallBack ) {
        QRCodeUtil qrCodeUtil=new QRCodeUtil();
        String uptoken=qrCodeUtil.getUptoken();
        Map<String,String> map=new HashMap<String, String>();
        map.put("uptoken",uptoken);
        return jsonCallBack+"("+ JSON.toJSONString(map)+")";
    }
}
