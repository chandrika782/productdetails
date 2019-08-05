package com.analytics.service;

import java.util.ArrayList;
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
import com.analytics.repository.ProductAnalyticsRepository;
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
	@Autowired
	ProductAnalyticsRepository productAnalyticsRepository;

	@Override
	public ResponseEntity<List<Categories>> getAll() {
		List<Categories> categris = categoriesRepository.findAll();
		return new ResponseEntity<>(categris, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Products>> getAll(Long categoryId) {
		List<Products> products = productRepository.getProductsByCategory(categoryId);
		return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Products>> getAllProducts(int userId, Long categoryId) {
		if (!userRepository.findById(userId).isPresent())
			throw new ProductException("user id is not exist");

		if (!categoriesRepository.findById(categoryId).isPresent())
			throw new ProductException("category id is not exist");

		Categories categoris = new Categories();
		categoris.setCategoryId(categoryId);

		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(userId);

		CategoryAnalytics categoryAnalytics = new CategoryAnalytics();
		categoryAnalytics.setCategories(categoris);
		categoryAnalytics.setUserDetails(userDetails);

		Optional<CategoryAnalytics> categoryRepo = categoryAnalyticsRepository.countOffCategoryHits(categoryId, userId);

		if (categoryRepo.isPresent()) {
			Long count = categoryRepo.get().getCount();

			System.out.println("count= " + count);

			categoryRepo.get().setCount(count + 1);

			categoryAnalyticsRepository.save(categoryRepo.get());
		} else {
			categoryAnalytics.setCount(1L);
			categoryAnalyticsRepository.save(categoryAnalytics);

		}
		
		return new ResponseEntity<>(productRepository.getProductsByCategory(categoryId), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Products> getProduct(Long categoryId, int userId, Long productId) {
		if (!userRepository.findById(userId).isPresent())
			throw new ProductException("user not existed");

		if (!productRepository.findById(productId).isPresent())
			throw new ProductException("product not existed");

		if (!categoriesRepository.findById(categoryId).isPresent())
			throw new ProductException("category not existed");

		Categories categoris = new Categories();
		categoris.setCategoryId(categoryId);

		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(userId);

		Products products = new Products();
		products.setProductId(productId);

		Optional<ProductAnalytics> productsAnalytics = productAnalyticsRepository.countOfProductsHits(productId,
				userId);

		if (productsAnalytics.isPresent()) {

			productsAnalytics.get().setCount(productsAnalytics.get().getCount() + 1);
			productAnalyticsRepository.save(productsAnalytics.get());

		} else {
			ProductAnalytics productsAnalyticsSave = new ProductAnalytics();
			productsAnalyticsSave.setProducts(products);
			productsAnalyticsSave.setCount(1L);
			productsAnalyticsSave.setUserdetails(userDetails);
			productsAnalyticsSave.setCategories(categoris);
			productAnalyticsRepository.save(productsAnalyticsSave);

		}

		return new ResponseEntity<>(productRepository.findById(productId).get(), HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<List<CategoryAnalytics>> getCategorysAnalytics() {
		List<?> CategoryAnalytics = categoryAnalyticsRepository.anlyticsOfCategoryHits();

		List<CategoryAnalytics> CategoryAnalyticslist = new ArrayList<>();
		for (Object obj : CategoryAnalytics) {

			CategoryAnalytics categoryAnalytics = new CategoryAnalytics();
			Object[] o = (Object[]) obj;

//			Categories category = new Categories();
//			category.setCategoryId(((Long) o[0]));

//			categoryAnalytics.setCategories(category);
			categoryAnalytics.setCategoryCountId(((Long) o[0]));
			categoryAnalytics.setCount((Long) o[1]);
			CategoryAnalyticslist.add(categoryAnalytics);

		}

		return new ResponseEntity<>(CategoryAnalyticslist, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ProductAnalytics>> getCategorysProductsAnalytics(Long categoryId) {
		if (!categoriesRepository.findById(categoryId).isPresent())
			throw new ProductException("category not existed");

		List<?> productsAnalytics = productAnalyticsRepository.anlyticsOfProductsHits(categoryId);

		List<ProductAnalytics> productAnalyticslist = new ArrayList<>();
		for (Object obj : productsAnalytics) {
			ProductAnalytics productAnalytics = new ProductAnalytics();
			Object[] o = (Object[]) obj;
			
//			Products products = new Products();
//			products.setProductId((Long) o[0]);
//			productAnalytics.setProducts(products);
//			
			productAnalytics.setProductCountId((Long) o[0]);
			productAnalytics.setCount((Long) o[1]);
			productAnalyticslist.add(productAnalytics);

		}

		return ResponseEntity.ok().body(productAnalyticslist);
	}

	
	@Override
	public ResponseEntity<List<ProductAnalytics>> getProductsAnalytics(Long productId) {
		if (!productRepository.findById(productId).isPresent())
			throw new ProductException("product not existed");

		List<?> productsAnalytics = productAnalyticsRepository.anlyticsOneProductHits(productId);

		List<ProductAnalytics> productAnalyticslist = new ArrayList<>();
		for (Object obj : productsAnalytics) {
			ProductAnalytics productAnalytics = new ProductAnalytics();
			Object[] o = (Object[]) obj;

//			Products products = new Products();
//			products.setProductId((Long) o[0]);
//			productAnalytics.setProducts(products);
			
			productAnalytics.setProductCountId((Long) o[0]);
			productAnalytics.setCount((Long) o[1]);
			productAnalyticslist.add(productAnalytics);
		}

		return ResponseEntity.ok().body(productAnalyticslist);
	}

}
