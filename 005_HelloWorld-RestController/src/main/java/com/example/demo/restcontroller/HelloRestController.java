package com.example.demo.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Friend;

@RestController
public class HelloRestController {
	
	private List<Friend>  friends = new ArrayList<Friend>();
	
	public  HelloRestController() {
		// TODO Auto-generated constructor stub
		Friend f1 = new Friend(1, "OBB", "Chennai");
		Friend f2 = new Friend(2, "CAS", "Bengaluru");
		Friend f3 = new Friend(3, "BNP", "Ahmedabad");
		Friend f4 = new Friend(4, "OWIOH", "Japan");
		
		friends.add(f1);
		friends.add(f2);
		friends.add(f3);
		friends.add(f4);
		
	}

	
	@RequestMapping("/")
	public String welcome() {
		return "Hello from Spring Boot 2.3.3!!!!Again";
	}
		
	@RequestMapping("/welcome")
	public String message() {
		return "Hello from Spring Boot DevTools!!!!";
	}
	
	@RequestMapping("/friends/all")
	public List<Friend> getAllFriends() {
		return friends;
	}
}
