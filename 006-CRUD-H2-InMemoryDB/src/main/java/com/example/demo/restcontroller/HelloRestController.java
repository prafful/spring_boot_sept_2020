package com.example.demo.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Friend;
import com.example.demo.service.FriendService;

@RestController
public class HelloRestController {
	
	@Autowired
	private FriendService friendService;
	
	
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
		return friendService.getAllFriends();
	}
	
	@RequestMapping(value = "/friends/add", method = RequestMethod.POST)
	public List<Friend> addFriend(@RequestBody Friend f) {
		return friendService.addFriend(f);
	}
	
	@RequestMapping(value = "/friends/get/{myid}")
	public Friend getFriendById(@PathVariable("myid") int id) {
		return friendService.getFriendById(id);
	}
	
	@RequestMapping(value = "/friends/del/{myid}", method = RequestMethod.DELETE)
	public List<Friend> deleteFriendById(@PathVariable("myid") int id) {
		return friendService.deleteFriendById(id);
		
	}
	
	@PutMapping("/friends/update/{myid}")
	//@RequestMapping(value = "/friends/update/{myid}", method = RequestMethod.PUT)
	public List<Friend> updateFriendById(@RequestBody Friend f, @PathVariable("myid") int id) {
		return friendService.updateFriendById(f, id);
	}
	
	
}
