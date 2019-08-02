package com.analytics.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CategoryAnalytics {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int categoryCountId;
private int Count;
@ManyToOne
private Categories categories;

public UserDetails getUserDetails() {
	return userDetails;
}
public void setUserDetails(UserDetails userDetails) {
	this.userDetails = userDetails;
}
public Categories getCategories() {
	return categories;
}
public void setCategories(Categories categories) {
	this.categories = categories;
}
@ManyToOne
private UserDetails userDetails;

public int getCategoryCountId() {
	return categoryCountId;
}
public void setCategoryCountId(int categoryCountId) {
	this.categoryCountId = categoryCountId;
}
public int getCount() {
	return Count;
}
public void setCount(int count) {
	Count = count;
}

}
