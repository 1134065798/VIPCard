package com.card.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1021 on 2017/11/3.
 */
public class GetOpenIdUtil {
    public static String getOpenid(String code){

        String appid="wxdb9a99feced63612";
        String secret="51a014f3486a89595facfdfd37290050";
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
        Map<String,String> params = new HashMap<String,String>();

        params.put("appid",appid);
        params.put("secret",secret);
        params.put("code",code);
        params.put("grant_type","authorization_code");
        String returnValue = HttpUtil.sendGet(url,params);


        JSONObject json = new JSONObject().parseObject(returnValue);
        String openid = json.getString("openid");
        return openid;
    }
}
