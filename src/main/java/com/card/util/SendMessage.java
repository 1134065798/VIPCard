package com.vipCardProject.spring.web.util;



import com.aliyuncs.http.MethodType;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;



public class SendMessage {
    public static void sendMessage(String phoneNumber,String code){
        try {
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIXFnK3G3rx2Cb", "gQvwX4DsC8j2CHe89c5kERWEfDORCn");
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms",  "sms.aliyuncs.com");
            IAcsClient client = new DefaultAcsClient(profile);
            SingleSendSmsRequest request = new SingleSendSmsRequest();
            request.setSignName("一卡通");
            request.setTemplateCode("SMS_106895070");
            request.setParamString("{ \"code\":\""+code+"\"}");
            request.setRecNum(phoneNumber);
            SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
            System.out.println(httpResponse);
        } catch (ServerException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
    }

}

