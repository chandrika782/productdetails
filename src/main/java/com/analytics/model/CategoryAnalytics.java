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
@ManyToOne(cascade = CascadeType.ALL)
private Categories categories;

@ManyToOne(cascade = CascadeType.ALL)
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
