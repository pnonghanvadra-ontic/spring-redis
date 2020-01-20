package com.example.springredis.repository;

import com.example.springredis.User;

import java.util.List;

public interface UserRepo {
    public void addUser(User user);
    public User getUser(String key);
    public void deleteUser(String key);
    public void updateUser(String key, User user);
    public List<User> getAllUsers();
    public void closeService();
}
