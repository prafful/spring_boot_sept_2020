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

import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	@Value("$(welcome.message)")
	private String message;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String welcome() {
		return message;
	}
	
	@RequestMapping("/all")
	public List<ProductEntity> getProducts() {
		return productService.getProducts();
	}
	
	@PostMapping("/add")
	public ProductEntity addProduct(@RequestBody ProductEntity pe) {
		return productService.addProduct(pe);
		
	}
	
	@GetMapping("/code/{productCode}")
	public ProductEntity getProductStockStatusByCode(@PathVariable String productCode) {
		return productService.getProductStockStatusByCode(productCode);
	}
	

}
