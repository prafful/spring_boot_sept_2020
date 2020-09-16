package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.Friend;
import com.example.demo.repository.FriendRepository;

@Repository
public class FriendDao {

	List<Friend> friends = null;
	
	@Autowired
	private FriendRepository friendRepository;
	
		
	public List<Friend> addFriend(Friend f) {
		FriendEntity fe = new FriendEntity();
		fe.setLocation(f.getLocation());
		fe.setName(f.getName());
		friendRepository.save(fe);
		List<FriendEntity> feList = friendRepository.findAll();
		friends = new ArrayList<Friend>();
		for(FriendEntity fetemp: feList) {
			Friend tempf = new Friend();
			tempf.setId(fetemp.getId());
			tempf.setLocation(fetemp.getLocation());
			tempf.setName(fetemp.getName());
			friends.add(tempf);
			
		}
		System.out.println(friends.toString());
		return friends;
	}
	
	
	public Friend getFriendById(int id) {
		Friend tempFriend = new Friend();
		for(int i=0; i<friends.size();i++) {
			tempFriend = friends.get(i);
			if(tempFriend.getId() == id) {
				return tempFriend;
			}
		}
		return null;
	}
	
	
	public List<Friend> deleteFriendById(int id) {
		Friend tempFriend = new Friend();
		for(int i=0; i<friends.size();i++) {
			tempFriend = friends.get(i);
			if(tempFriend.getId() == id) {
				friends.remove(i);
			}
		}
		return friends;
	}
	
	
	public List<Friend> updateFriendById(Friend f, int id) {
		Friend tempFriend = new Friend();
		for(int i=0; i<friends.size();i++) {
			tempFriend = friends.get(i);
			if(tempFriend.getId() == id) {
				friends.set(i,f);
			}
		}
		return friends;
	}
	
	public List<Friend> getAllFriends() {
		return friends;
	}
	
}
