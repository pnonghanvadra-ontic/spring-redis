package com.example.springredis;

import com.example.springredis.repository.UserRepo;
import com.example.springredis.repository.UserRepoImpl;
import com.example.springredis.services.RedisService;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean(name = "config")
    public Config getConfig(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        return config;
    }

//    @Bean(name = "redisclient")
//    public RedissonClient getRedissonClient(Config config){
//        return Redisson.create(config);
//    }

    @Bean(name = "userrepo")
    public UserRepo getuserrepo(RedisService redisService){
        return new UserRepoImpl(redisService);
    }

    @Bean(name = "redisservice")
    public RedisService getRedisService(Config config){
        return new RedisService(config);
    }
}
