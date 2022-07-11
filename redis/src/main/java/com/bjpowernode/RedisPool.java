package com.bjpowernode;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author qinang
 * @version 2.0
 * 设计一个Redis连接池
 * 其实已经设计好了   只需要配置一下参数即可
 */
public class RedisPool {
    private static JedisPool pool = null;

    //创建连接池的方法
    public static JedisPool getPool(String hostName, int port) {
        if (pool == null){//只有当连接池为空的时间 才创建连接池
            JedisPoolConfig config = new JedisPoolConfig();
            //最大连接数
            config.setMaxTotal(10);
            //最大空闲连接数
            config.setMaxIdle(5);
            //创建连接池
            pool = new JedisPool(config,hostName,port);
        }
        return pool;
    }
    //关闭连接池
    public static void close(){
        if (pool != null){
            pool.close();
        }
    }
}
