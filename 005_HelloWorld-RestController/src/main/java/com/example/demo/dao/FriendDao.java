package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Friend;

@Repository
public class FriendDao {

	private List<Friend>  friends = new ArrayList<Friend>();
	
	public FriendDao() {
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
	
	
	public List<Friend> addFriend(Friend f) {
		friends.add(f);
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
