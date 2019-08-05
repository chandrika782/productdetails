package com.analytics.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.analytics.model.ProductAnalytics;

@Repository
public interface ProductAnalyticsRepository extends JpaRepository<ProductAnalytics, Long> {

	@Query("SELECT u FROM ProductAnalytics u WHERE u.products.productId = :productId and  u.userdetails.userId = :userId")
	public Optional<ProductAnalytics> countOfProductsHits(@Param("productId") Long productId,
			@Param("userId") int userId);

	@Query("SELECT u.products.productId, sum(u.count)  from ProductAnalytics u where u.categories.categoryId=:categoryId group by u.products.productId ")
	public List<?> anlyticsOfProductsHits(@Param("categoryId") Long categoryId);

	@Query("SELECT u.products.productId, sum(u.count)  from ProductAnalytics u where u.products.productId=:productId")
	public List<?> anlyticsOneProductHits(@Param("productId") Long productId);

}
