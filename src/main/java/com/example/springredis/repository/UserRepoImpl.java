package com.example.springredis.repository;

import com.example.springredis.User;
import com.example.springredis.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class UserRepoImpl implements UserRepo {

    private RedisService redisService;

    @Autowired
    public UserRepoImpl(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public void addUser(User user) {
        redisService.addMapPair("USER",user.getEmail(),user);
    }

    @Override
    public User getUser(String email) {
        return (User) redisService.getMapPairValue("USER",email);
    }

    @Override
    public void deleteUser(String email) {
        redisService.deleteMapPair("USER", email);
    }

    @Override
    public void updateUser(String email, User user) {
        redisService.addMapPair("USER",email, user);
    }
    @Override
    public void closeService(){
        this.redisService.close();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;
        Map<String, Object> map = this.redisService.getMap("USER");
        if(map.isEmpty())
            return new ArrayList<>(0);
        users = new ArrayList<>();
        for (Map.Entry<String,Object> user : map.entrySet()){
            users.add((User)user.getValue());
        }
            return users;
    }
}
