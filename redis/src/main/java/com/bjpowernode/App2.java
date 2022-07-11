package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App2 {
    public static void main(String[] args) {
        JedisPool pool = null;
        try {
            pool = RedisPool.getPool("192.168.229.128", 6379);
            Jedis redis = pool.getResource();
            redis.flushDB();
            redis.hset("NBA_player","Warriors","Curry");
            String hget = redis.hget("NBA_player", "Warriors");
            System.out.println(hget);

            //还可以将数据放在map中  再通过hmset存放map
            Map<String, String> map = new HashMap<>();
            map.put("Bulls", "Qin Ang");
            map.put("Sixer","Harden");
            redis.hmset("NBA_Player",map);
            List<String> hmget = redis.hmget("NBA_Player", "Bulls", "Sixer");
            System.out.println(hmget);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtils.close();
        }
    }
}
