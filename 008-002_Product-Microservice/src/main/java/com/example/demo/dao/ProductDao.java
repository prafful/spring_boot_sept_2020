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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


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

	@HystrixCommand(fallbackMethod = "getProductStockStatusByCode_Failed",
			commandProperties = {
				@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "4400")
			})
	public ProductEntity getProductStockStatusByCode(String productCode) {
		// TODO Auto-generated method stub
		//check if code is valid
		/*
		 * try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		ProductEntity tempPE = new ProductEntity();
		tempPE = productRepository.findByProductCode(productCode);
		//String url = "http://localhost:9992/api/code/" + productCode;
		String url = "http://localhost:8080/shop/inventory/api/code/" + productCode;
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
	
	public ProductEntity getProductStockStatusByCode_Failed(String productCode) {
		System.out.println("************************    Failed     ***********************");
		return productRepository.findByProductCode(productCode);
	}

}
