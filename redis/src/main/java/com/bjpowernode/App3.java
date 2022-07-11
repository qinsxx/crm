package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

public class App3 {
    public static void main(String[] args) {
        JedisPool pool = null;
        try {
            pool = RedisPool.getPool("192.168.229.128", 6379);
            Jedis redis = pool.getResource();
            redis.flushAll();
            Transaction trans = redis.multi();//开启事务  接下来的命令都由 trans来做
            trans.set("a","2");
            trans.set("b","3");
            trans.get("a");
            List<Object> exec = trans.exec();
            System.out.println(exec);


        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            RedisPool.close();
        }
    }
}
