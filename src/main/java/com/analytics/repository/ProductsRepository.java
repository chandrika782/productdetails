package com.analytics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.analytics.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

	@Query("SELECT u FROM Products u WHERE u.categories.categoryId=:categoryId")
	public List<Products>getProductsByCategory(@Param("categoryId") Long categoryId);

}
