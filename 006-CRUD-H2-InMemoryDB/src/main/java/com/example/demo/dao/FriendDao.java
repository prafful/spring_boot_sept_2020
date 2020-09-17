package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
		Optional<FriendEntity> feOptional = friendRepository.findById(id);
		if (feOptional.isPresent()) {
			FriendEntity fe = feOptional.get();
			tempFriend.setId(fe.getId());
			tempFriend.setName(fe.getName());
			tempFriend.setLocation(fe.getLocation());
			return tempFriend;
		}else {
			return tempFriend;
		}
		
	
	}
	
	
	public List<Friend> deleteFriendById(int id) {
		Friend tempFriend = new Friend();
		
		Optional<FriendEntity> feOptional = friendRepository.findById(id);
		
		friends = new ArrayList<Friend>();
		
		if (feOptional.isPresent()) {
			friendRepository.deleteById(id);
			
			List<FriendEntity> feList =  friendRepository.findAll();
			
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
		else {
			return friends;
		}
		
		
		
		
		
	}
	
	
	public List<Friend> updateFriendById(Friend f, int id) {
	
		Optional<FriendEntity> feOptional = friendRepository.findById(id);
		
		friends = new ArrayList<Friend>();
		
		if (feOptional.isPresent()) {
			FriendEntity feTemp = new FriendEntity(id, f.getName(), f.getLocation());
			friendRepository.saveAndFlush(feTemp);
			
			List<FriendEntity> feList =  friendRepository.findAll();
			
			for(FriendEntity fetemp: feList) {
				Friend tempf = new Friend();
				tempf.setId(fetemp.getId());
				tempf.setLocation(fetemp.getLocation());
				tempf.setName(fetemp.getName());
				friends.add(tempf);
				
			}
			System.out.println(friends.toString());
			return friends;
			
		}else {
			return friends;
		}
	}	
	
	public List<Friend> getAllFriends() {
		List<FriendEntity> feList =  friendRepository.findAll();
		
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
	
	
	public List<Friend> getFriendByName(String name) {
		List<FriendEntity> feList =  friendRepository.findByName(name);
		
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
	
	
	public List<Friend> getFriendByNameContaining(String name) {
		// TODO Auto-generated method stub
				List<FriendEntity> feList =  friendRepository.findByNameContaining(name);
				
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


	public List<Friend> getFriendByLocation(String location) {
		// TODO Auto-generated method stub
		List<FriendEntity> feList =  friendRepository.findByLocation(location);
		
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
	
	
	
}
