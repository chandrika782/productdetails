package com.analytics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.analytics.model.Categories;
import com.analytics.model.CategoryAnalytics;
import com.analytics.model.ProductAnalytics;
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
	public ResponseEntity<List<Products>> getProducts(@PathVariable("id") Long categoryId){
		return productsService.getAll(categoryId);
		
	}
	@GetMapping("/user/{uid}/category/{cid}")
	public ResponseEntity<List<Products>> getAllProducts(@PathVariable("uid") int userId,@PathVariable("cid")Long categoryId){
		return productsService.getAllProducts(userId, categoryId);
		
	}
	@GetMapping("/{categoryId}/user/{userId}/products/{productId}")
	public ResponseEntity<Products> getProduct(@PathVariable("categoryId") Long categoryId,@PathVariable("productId")Long productId, @PathVariable("userId") int userId){
		return productsService.getProduct(categoryId,userId,productId);
		}
	
	
	@GetMapping("/analytics")
	public ResponseEntity<List<CategoryAnalytics>> getCategorysAnalytics(){
		return productsService.getCategorysAnalytics();
		}

	@GetMapping("/analytics/{categoryId}/products")
	public ResponseEntity<List<ProductAnalytics>> getCategorysProductsAnalytics(Long categoryId) {
		return productsService.getCategorysProductsAnalytics(categoryId);
	}

	@GetMapping("/analytics/products/{productId}")
	public ResponseEntity<List<ProductAnalytics>> getProductsAnalytics(Long productId) {
		return productsService.getProductsAnalytics(productId);

	}
	 
}
