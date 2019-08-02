package com.analytics.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.analytics.model.CategoryAnalytics;
@Repository
public interface CategoryAnalyticsRepository extends JpaRepository<CategoryAnalytics, Integer> {

	@Query("SELECT u from CategoryAnalytics u where u.categories.categoryId=:categoryId and u.userDetails.userId=:userId")
	public Optional<CategoryAnalytics> countOffCategoryHits(@Param("categoryId") int categoryId,@Param("userId") int userId);
	
}
