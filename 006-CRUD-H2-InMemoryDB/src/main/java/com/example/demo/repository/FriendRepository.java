package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.pojo.Friend;

public interface FriendRepository extends JpaRepository<Friend	, Integer> {

}
