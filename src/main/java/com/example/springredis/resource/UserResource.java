package com.example.springredis.resource;

import com.example.springredis.User;
import com.example.springredis.repository.UserRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResource {
    private UserRepo userRepo;

    public UserResource(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/add/{id}/{name}")
    public User add (@PathVariable("id") final String id, @PathVariable("name") final String name){
        userRepo.addUser(new User.UserBuilder("p@o.com",name, "Nonghanvadra").build());
        return userRepo.getUser("p@o.com");
    }
}
