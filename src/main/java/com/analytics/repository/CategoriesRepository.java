package com.analytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.analytics.model.Categories;
import com.analytics.model.CategoryAnalytics;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
	

}
