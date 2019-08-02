package com.analytics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.analytics.exception.ProductException;
import com.analytics.model.Categories;
import com.analytics.model.CategoryAnalytics;
import com.analytics.model.ProductAnalytics;
import com.analytics.model.Products;
import com.analytics.model.UserDetails;
import com.analytics.repository.CategoriesRepository;
import com.analytics.repository.CategoryAnalyticsRepository;
import com.analytics.repository.ProductsRepository;
import com.analytics.repository.UserRepository;

@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	ProductsRepository productRepository;
	@Autowired
	CategoriesRepository categoriesRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CategoryAnalyticsRepository categoryAnalyticsRepository;

	@Override
	public ResponseEntity<List<Categories>> getAll() {
		List<Categories> categris = categoriesRepository.findAll();
		return new ResponseEntity<>(categris, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Products>> getAll(int categoryId) {
		List<Products> products = productRepository.getProductsByCategory(categoryId);
		return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Products>> getAllProducts(int userId, int categoryId) {
		if (!userRepository.findById(userId).isPresent())
			throw new ProductException("user id is not exist");
		
		if (!categoriesRepository.findById(categoryId).isPresent())
			throw new ProductException("category id is not exist");
		
		Categories categoris=new Categories();
		categoris.setCategoryId(categoryId);
		
		UserDetails userDetails=new UserDetails();
		userDetails.setUserId(userId);
		
		CategoryAnalytics categoryAnalytics=new CategoryAnalytics();
		categoryAnalytics.setCategories(categoris);
		categoryAnalytics.setUserDetails(userDetails);
		
		Optional<CategoryAnalytics> categoryRepo = categoryAnalyticsRepository.countOffCategoryHits(categoryId, userId);
		
		if(categoryRepo.isPresent()) {
			int count = categoryRepo.get().getCount();
			
			System.out.println("count= "+count);
			
			categoryRepo.get().setCount(count+1);
			
			categoryAnalyticsRepository.save(categoryRepo.get());
		}
		else {
			categoryAnalytics.setCount(1);
			categoryAnalyticsRepository.save(categoryAnalytics);
			
		}
		List<Products> prdcts = productRepository.findAll();
		return new ResponseEntity<List<Products>>(prdcts, HttpStatus.OK);
	}

}
