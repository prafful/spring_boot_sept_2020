package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Friend;
import com.example.demo.repository.FriendRepository;

@Repository
public class FriendDao {

	@Autowired
	private FriendRepository friendRepository;
	
	
	public List<Friend> addFriend(Friend f) {
		friendRepository.save(f);
		return friendRepository.findAll();
	}
	
	
	public Friend getFriendById(int id) {
		Optional<Friend> optionalFriend =  friendRepository.findById(id);
		Friend f = new Friend();
		if(optionalFriend.isPresent()) {
			f = optionalFriend.get();
		}
		return f;
	}
	
	
	public List<Friend> deleteFriendById(int id) {
		Optional<Friend> optionalFriend =  friendRepository.findById(id);
		if(optionalFriend.isPresent()) {
			friendRepository.deleteById(id);
		}
		return friendRepository.findAll();
	}
	
	
	public List<Friend> updateFriendById(Friend f, int id) {
		Optional<Friend> optionalFriend =  friendRepository.findById(id);
		Friend friend = new Friend();
		if(optionalFriend.isPresent()) {
			//friend = optionalFriend.get();
			friend.setLocation(f.getLocation());
			friend.setName(f.getName());
			friend.setId(id);
			friendRepository.save(friend);
		}
		return friendRepository.findAll();
	}
	
	public List<Friend> getAllFriends() {
		return friendRepository.findAll();
	}
	
}
