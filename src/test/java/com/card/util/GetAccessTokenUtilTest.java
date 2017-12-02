package com.card.util;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by 1021 on 2017/10/29.
 */
public class GetAccessTokenUtilTest {
    @Test
    public void testgetAccessToken() throws Exception {

        Jedis jedis=RedisPool.getRedis();
        String access_token=null;
        if(jedis.exists("access_token")==false) {
            access_token= GetAccessTokenUtil.getAccessToken();
            jedis.set("access_token",access_token);
            jedis.expire("access_token",5400);
        }else{
            access_token=jedis.get("access_token");
        }
        //查看剩余时间
        System.out.println("time:"+jedis.ttl("access_token"));
        System.out.println("access_token:"+access_token);
    }
}