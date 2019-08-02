package com.analytics.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.analytics.model.Categories;
import com.analytics.model.Products;

public interface ProductsService {
	
	public ResponseEntity<List<Categories>> getAll();
	
	public ResponseEntity<List<Products>> getAll(int categoryId);
	
	public ResponseEntity<List<Products>> getAllProducts(int userId,int categoryId);

}
