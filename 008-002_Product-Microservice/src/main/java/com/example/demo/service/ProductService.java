package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.ProductEntity;
import com.netflix.discovery.converters.Auto;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;

	public List<ProductEntity> getProducts() {
		// TODO Auto-generated method stub
		return productDao.getProducts();
	}

	public ProductEntity addProduct(ProductEntity pe) {
		// TODO Auto-generated method stub
		return productDao.addProduct(pe);
	}

	public ProductEntity getProductStockStatusByCode(String productCode) {
		// TODO Auto-generated method stub
		return productDao.getProductStockStatusByCode(productCode);
	}

}
