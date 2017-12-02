package com.card.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by 1021 on 2017/11/26.
 */
public class RedisPool {
    private static JedisPool POOL;
    static{
       JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);
        config.setMaxIdle(10);
        POOL = new JedisPool(config,"47.95.222.74");
    }

    public static Jedis getRedis(){
        return POOL.getResource();
    }
}
