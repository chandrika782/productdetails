package com.analytics.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CategoryAnalytics {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long categoryCountId;

private Long Count;

@JsonIgnore
@ManyToOne
private Categories categories;


@JsonIgnore
@ManyToOne
private UserDetails userDetails;


public Long getCategoryCountId() {
	return categoryCountId;
}


public void setCategoryCountId(Long categoryCountId) {
	this.categoryCountId = categoryCountId;
}


public Long getCount() {
	return Count;
}


public void setCount(Long count) {
	Count = count;
}


public Categories getCategories() {
	return categories;
}


public void setCategories(Categories categories) {
	this.categories = categories;
}


public UserDetails getUserDetails() {
	return userDetails;
}


public void setUserDetails(UserDetails userDetails) {
	this.userDetails = userDetails;
}



}
