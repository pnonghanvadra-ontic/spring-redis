package com.example.springredis.services;

import org.redisson.config.Config;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


public class RedisService {

    private RedissonClient redissonClient;

    @Autowired
    public RedisService(Config config) {
        try {
            this.redissonClient = Redisson.create(config);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addPair(String key, Object value){
        redissonClient.getBucket(key).set(value);
    }

    public Object getValue(String key){
        return (String)redissonClient.getBucket(key).get();
    }

    public void addMapPair(String at, String key, Object value){
        redissonClient.getMap(at).put(key, value);
    }

    public Object getMapPairValue(String at, String key){
        return redissonClient.getMap(at).get(key);
    }

    public Map<String, Object> getMap(String at){
        return redissonClient.getMap(at);
    }

    public void deleteMapPair(String at, String which){
        redissonClient.getMap(at).remove(which);
    }


    public void close(){
        this.redissonClient.shutdown();
    }

}
