package com.bjpowernode;

import redis.clients.jedis.Jedis;

public class App {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.229.128",6379);//连接虚拟机中的ip地址  和端口号
        jedis.flushDB();
        jedis.set("a","123");
        String a = jedis.get("a");
        System.out.println(a);
    }
}
