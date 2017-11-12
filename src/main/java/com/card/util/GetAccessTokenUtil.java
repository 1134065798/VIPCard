package com.card.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1021 on 2017/11/4.
 */
public class GetAccessTokenUtil {
    public static String getAccessToken(){

        String accessTokenurl = "https://api.weixin.qq.com/cgi-bin/token";
        String appid=PropertyUtil.getValue_String("weixin.appid");
        String secret=PropertyUtil.getValue_String("weixin.secret");
        String grant_type="client_credential";

        Map<String,String> params = new HashMap<String,String>();
        params.put("appid",appid);
        params.put("secret",secret);
        params.put("grant_type",grant_type);

        String url=HttpUtil.sendGet(accessTokenurl,params);
        JSONObject json = new JSONObject().parseObject(url);
        String access_token = json.getString("access_token");
        return access_token;
    }
}
