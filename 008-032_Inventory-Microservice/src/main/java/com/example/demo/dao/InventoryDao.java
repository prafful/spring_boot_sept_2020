package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.InventoryEntity;
import com.example.demo.repository.InventoryRepository;

@Repository
public class InventoryDao {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	
	public List<InventoryEntity> getAllInventory() {
		return inventoryRepository.findAll();
	}
	
	public InventoryEntity addInventory(InventoryEntity ie) {
		return inventoryRepository.save(ie);
	}
	
	public InventoryEntity getInventoryStockStatusByProductCode(String productCode) {
		return inventoryRepository.findByProductCode(productCode);
	}
	

}
