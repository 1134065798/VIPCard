package com.card.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by ypj on 2017/11/14.
 */
public class Demo {

    @Test
    public void fun(){
        Jedis jedis=new Jedis("47.95.222.74",6379);
        jedis.set("name","zs");
        String name = jedis.get("phone");
        System.out.print(name);
    }
}
