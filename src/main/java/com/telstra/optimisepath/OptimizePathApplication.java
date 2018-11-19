package com.telstra.optimisepath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class OptimizePathApplication {
//	@Autowired
//	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(OptimizePathApplication.class, args);
	}

//	@PostConstruct
//	public void setupDbWithData(){
//		User user= new User("Ashish", null);
//		user.setSkills(Arrays.asList(new Skill("java"), new Skill("js")));
//		user= userRepository.save(user);
//	}
}
