package com.card.util;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

import java.util.ArrayList;

/**
 * Created by 69027 on 2017/11/2.
 */
public class SendMessageUtil {
    public static void sendMesaage(String phone,String code) {
                try {
                    //请根据实际 appid 和 appkey 进行开发
                    int appid = 1400048505;
                    String appkey = "65209ff38888533ba855a6e868a813f4";
                    int tmplId = 53880;

                    //初始化单发
                    SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
                    SmsSingleSenderResult singleSenderResult;

                    //指定模板单发
                    ArrayList<String> params = new ArrayList<String>();
                    params.add(code);
                    singleSenderResult = singleSender.sendWithParam("86", phone, tmplId, params, "短信验证", "", "");
                    System.out.println(singleSenderResult);

                } catch (Exception e) {
                    e.printStackTrace();
                }

    }
}
