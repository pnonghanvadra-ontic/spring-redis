package com.example.springredis;

import com.example.springredis.repository.UserRepo;
import com.example.springredis.services.RedisService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		UserRepo userRepo = (UserRepo) context.getBean("userrepo");

		User user1 = new User.UserBuilder("p@ontic.ai","Pragnesh","Nonghanvadra").build();
		userRepo.addUser(user1);
		User user2 = new User.UserBuilder("pnonghanvadra@ontic.ai","Pragnesh","Nonghanvadra").phone("9978423362").age("21").build();
		userRepo.addUser(user2);
		User user3 = new User.UserBuilder("pragneshbn092@gmail.com","Pragnesh","Nonghanvadra").phone("8320252688").age("22").build();
		userRepo.addUser(user3);
//		System.out.println(userRepo.getUser(user1.getEmail()));
		List<User> users = userRepo.getAllUsers();
		for(User user:users){
			System.out.println(user);
		}
		SpringApplication.exit(context);
	}

}
