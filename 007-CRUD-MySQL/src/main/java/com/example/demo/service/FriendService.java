package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FriendDao;
import com.example.demo.pojo.Friend;

@Service
public class FriendService {
	
	@Autowired
	private FriendDao friendDao;

	public List<Friend> getAllFriends() {
		// TODO Auto-generated method stub
		return friendDao.getAllFriends();
	}

	public List<Friend> addFriend(Friend f) {
		// TODO Auto-generated method stub
		return friendDao.addFriend(f);
	}

	public Friend getFriendById(int id) {
		// TODO Auto-generated method stub
		return friendDao.getFriendById(id);
	}

	public List<Friend> deleteFriendById(int id) {
		// TODO Auto-generated method stub
		return friendDao.deleteFriendById(id);
	}

	public List<Friend> updateFriendById(Friend f, int id) {
		// TODO Auto-generated method stub
		return friendDao.updateFriendById(f, id);
	}

	public List<Friend> getFriendByName(String name) {
		// TODO Auto-generated method stub
		return friendDao.getFriendByName(name);
	}

	public List<Friend> getFriendByLocation(String location) {
		// TODO Auto-generated method stub
		return friendDao.getFriendByLocation(location);
	}

	public List<Friend> getFriendByNameContaining(String name) {
		// TODO Auto-generated method stub
		return friendDao.getFriendByNameContaining(name);
	}

}
