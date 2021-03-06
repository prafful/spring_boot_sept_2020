package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.InventoryEntity;


public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {

	InventoryEntity findByProductCode(String productCode);
	
}
