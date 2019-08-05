package com.analytics.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.analytics.model.Categories;
import com.analytics.model.CategoryAnalytics;
import com.analytics.model.ProductAnalytics;
import com.analytics.model.Products;

public interface ProductsService {

	public ResponseEntity<List<Categories>> getAll();

	public ResponseEntity<List<Products>> getAll(Long categoryId);

	public ResponseEntity<List<Products>> getAllProducts(int userId, Long categoryId);

	public ResponseEntity<Products> getProduct(Long categoryId, int userId, Long productId);

	public ResponseEntity<List<CategoryAnalytics>> getCategorysAnalytics();

	public ResponseEntity<List<ProductAnalytics>> getCategorysProductsAnalytics(Long categoryId);

	public ResponseEntity<List<ProductAnalytics>> getProductsAnalytics(Long productId);

}
