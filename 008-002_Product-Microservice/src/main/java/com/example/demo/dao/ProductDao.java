package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.InventoryResponse;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public List<ProductEntity> getProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}


	public ProductEntity addProduct(ProductEntity pe) {
		// TODO Auto-generated method stub
		return productRepository.save(pe);
	}


	public ProductEntity getProductStockStatusByCode(String productCode) {
		// TODO Auto-generated method stub
		//check if code is valid
		ProductEntity tempPE = new ProductEntity();
		tempPE = productRepository.findByProductCode(productCode);
		String url = "http://localhost:9992/api/code/" + productCode;
		ResponseEntity<InventoryResponse> inventoryResponse = restTemplate.getForEntity(url, InventoryResponse.class);
		System.out.println("Response from inventory ms: " + inventoryResponse.toString());
		
		if(inventoryResponse.getStatusCode() == HttpStatus.OK) {
			if(inventoryResponse.getBody().getQuantity() > 0) {
				tempPE.setProductStockStatus(true);
				productRepository.saveAndFlush(tempPE);
			}else {
				tempPE.setProductStockStatus(false);
				productRepository.saveAndFlush(tempPE);
			}
			
		}
		
		return productRepository.findByProductCode(productCode);
	}

}
