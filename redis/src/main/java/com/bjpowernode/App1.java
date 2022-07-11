package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class App1 {
    public static void main(String[] args) {
        JedisPool pool = null;
        try {
            pool = RedisPool.getPool("192.168.229.128", 6379);
            Jedis redis = pool.getResource();//获得Jedis
            redis.select(2);
            redis.set("age", "21");
            String age = redis.get("age");
            System.out.println(age);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            pool.close();
        }

    }
}
