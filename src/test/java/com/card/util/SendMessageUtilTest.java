package com.card.util;

import com.card.controller.CodeController;
import org.apache.log4j.Logger;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import static org.junit.Assert.*;

/**
 * Created by 69027 on 2017/11/26.
 */
public class SendMessageUtilTest {
    private static final Logger log= Logger.getLogger(CodeController.class);
    @Test
    public void sendMesaage() throws Exception {
        log.info("发送验证码");

        String s=String.valueOf(System.currentTimeMillis());
        String code=s.substring(s.length()-4,s.length());

        Jedis jedis = RedisPool.getRedis();
        jedis.set("15829085136",code);
        jedis.expire("15829085136",60);

        SendMessageUtil.sendMesaage("15829085136",code);
        //return "register"+phone+"--"+jedis.get("phone");
    }

}