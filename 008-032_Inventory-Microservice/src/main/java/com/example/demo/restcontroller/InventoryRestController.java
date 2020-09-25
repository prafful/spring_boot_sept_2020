package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.InventoryEntity;
import com.example.demo.service.InventoryService;

@RestController
@RequestMapping("/api")
public class InventoryRestController {

	
	@Value("$(welcome.message)")
	private String message;
	
	
	@Autowired
	private InventoryService inventoryService;
	
	@RequestMapping("/")
	public String welcome() {
		return message;
	}
	
	
	@GetMapping("/all")
	public List<InventoryEntity> getAllInventory() {
		return inventoryService.getAllInventory();
	}
	
	@PostMapping("/add")
	public InventoryEntity addInventory(@RequestBody InventoryEntity ie) {
		return inventoryService.addInventory(ie);
	}
	
	@GetMapping("/code/{productCode}")
	public InventoryEntity getInventoryStockStatusByProductCode(@PathVariable String productCode) {
		return inventoryService.getInventoryStockStatusByProductCode(productCode);
	}
	
	
}
