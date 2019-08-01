package com.analytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.analytics.model.ProductAnalytics;

@Repository
public interface ProductAnalyticsRepository extends JpaRepository<ProductAnalytics, Integer> {

}