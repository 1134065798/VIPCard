package com.card.test;

import com.card.util.SendMessageUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import static org.junit.Assert.*;

/**
 * Created by 69027 on 2017/11/4.
 */
public class SendMessageUtilTest {
    @Test
    public void sendMesaage() throws Exception {
        String s=String.valueOf(System.currentTimeMillis());
        String code=s.substring(s.length()-4,s.length());

        Jedis jedis = new Jedis("47.95.222.74",6379);
        jedis.set("phone",code);
        jedis.expire("phone",60);
        //测试代码
        //String code1=jedis.get("phone");
        //System.out.print(code1);
        jedis.close();


      SendMessageUtil.sendMesaage("15829085136",code);

    }

}