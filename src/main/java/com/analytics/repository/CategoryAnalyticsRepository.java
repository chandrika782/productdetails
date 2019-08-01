package com.analytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.analytics.model.CategoryAnalytics;
@Repository
public interface CategoryAnalyticsRepository extends JpaRepository<CategoryAnalytics, Integer> {

}
