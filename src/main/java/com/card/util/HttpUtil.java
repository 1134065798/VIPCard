package com.card.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * Created by 1021 on 2017/11/2.
 */
public class HttpUtil {

    public static String sendGet(String url,Map<String,String> params) {
        //将map转为url参数
        if (params == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String s = sb.toString();
        s = s.substring(0, s.length() - 1);

        //以get方式
        String result = "";
        BufferedReader in = null;
        String urlNameString;
        urlNameString = url + "?" + s;
        try {
            URL realUrl = new URL(urlNameString);
            URLConnection connection = realUrl.openConnection();

            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
          } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
