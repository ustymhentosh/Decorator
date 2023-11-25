package com.example.flower;

import redis.clients.jedis.Jedis;

public class RedisExample {

    public static void main(String[] args) {
        // Connect to the local Redis server (default port is 6379)
        try (Jedis jedis = new Jedis("localhost")) {
            System.out.println("Connected to Redis");
        }
    }
}
