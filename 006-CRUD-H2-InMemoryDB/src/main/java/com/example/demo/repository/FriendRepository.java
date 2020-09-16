package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FriendEntity;

public interface FriendRepository extends JpaRepository<FriendEntity, Integer> {

}
