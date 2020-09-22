package com.example.demo.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class DatabaseInit implements CommandLineRunner{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user1 = new User();
		user1.setActive(1);
		user1.setUsername("visitor");
		user1.setPassword(passwordEncoder.encode("visitor1234"));
		user1.setRoles("VISITOR");
		user1.setPermissions("");
		
		User user2 = new User();
		user2.setActive(1);
		user2.setUsername("manager");
		user2.setPassword(passwordEncoder.encode("manager1234"));
		user2.setRoles("VISITOR,MANAGER");
		user2.setPermissions("");
		
		
		
		User user3 = new User();
		user3.setActive(1);
		user3.setUsername("admin");
		user3.setPassword(passwordEncoder.encode("admin1234"));
		user3.setRoles("VISITOR,MANAGER,ADMIN");
		user3.setPermissions("");
		
		List<User> users = Arrays.asList(user1, user2, user3);
		
		userRepository.saveAll(users);
		
	}

}
