package com.card.test;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by ypj on 2017/11/14.
 */
public class Demo {
    private static final Logger log=Logger.getLogger(Demo.class);
    @Test
    public void fun(){
        log.info("info");
//        Jedis jedis=new Jedis("47.95.222.74",6379);
//        jedis.set("name","zs");
//        String name = jedis.get("phone");
//        System.out.print(name);
    }
}
