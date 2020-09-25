package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	// all get requests
	
	@RequestMapping("/get")
	public List<Friend> getAllFriends() {
		return friendService.getAllFriends();
	}
	
	@RequestMapping(value = "/get/{myid}")
	public Friend getFriendById(@PathVariable("myid") int id) {
		return friendService.getFriendById(id);
	}
	
	@GetMapping("/get/findbyname/{name}")
	public List<Friend> getFriendByName(@PathVariable String name){
		return friendService.getFriendByName(name);
	}
	
	@GetMapping("/get/findbylocation/{location}")
	public List<Friend> getFriendByLocation(@PathVariable String location){
		return friendService.getFriendByLocation(location);
	}
	
	@GetMapping("/get/namecontain/{name}")
	public List<Friend> getFriendByNameContaining(@PathVariable String name){
		return friendService.getFriendByNameContaining(name);
	}
	
	//post request
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<Friend> addFriend(@RequestBody Friend f) {
		return friendService.addFriend(f);
	}
	
	
	//delete request
	
	@DeleteMapping("/del/{myid}")
	public List<Friend> deleteFriendById(@PathVariable("myid") int id) {
		return friendService.deleteFriendById(id);
		
	}
	
	//update request
	
	@PutMapping("/update/{myid}")
	//@RequestMapping(value = "/friends/update/{myid}", method = RequestMethod.PUT)
	public List<Friend> updateFriendById(@RequestBody Friend f, @PathVariable("myid") int id) {
		return friendService.updateFriendById(f, id);
	}
	
	
	
	
}
