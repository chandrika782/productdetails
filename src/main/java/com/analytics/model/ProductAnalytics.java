package com.analytics.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProductAnalytics {
@Id
@GeneratedValue(strategy =GenerationType.AUTO)
private Long productCountId;
private Long count;

@JsonIgnore
@ManyToOne
private Products products;

@JsonIgnore
@ManyToOne
private UserDetails userdetails;


@JsonIgnore
@ManyToOne
private Categories categories;

public Categories getCategories() {
	return categories;
}
public void setCategories(Categories categories) {
	this.categories = categories;
}



public Products getProducts() {
	return products;
}
public void setProducts(Products products) {
	this.products = products;
}
public UserDetails getUserdetails() {
	return userdetails;
}
public void setUserdetails(UserDetails userdetails) {
	this.userdetails = userdetails;
}
public Long getProductCountId() {
	return productCountId;
}
public void setProductCountId(Long productCountId) {
	this.productCountId = productCountId;
}
public Long getCount() {
	return count;
}
public void setCount(Long count) {
	this.count = count;
}

}
