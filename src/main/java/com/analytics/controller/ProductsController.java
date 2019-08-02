package com.analytics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.analytics.model.Categories;
import com.analytics.model.Products;
import com.analytics.service.ProductsService;
@RestController
@RequestMapping("/Products")
public class ProductsController {
	@Autowired
	ProductsService productsService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Categories>> getCatrgories(){
		return productsService.getAll();
		
	}
	@GetMapping("/all/{id}")
	public ResponseEntity<List<Products>> getProducts(@PathVariable("id") int categoryId){
		return productsService.getAll(categoryId);
		
	}
	@GetMapping("/user/{uid}/category/{cid}")
	public ResponseEntity<List<Products>> getAllProducts(@PathVariable("uid") int userId,@PathVariable("cid")int categoryId){
		return productsService.getAllProducts(userId, categoryId);
		
	}
}
