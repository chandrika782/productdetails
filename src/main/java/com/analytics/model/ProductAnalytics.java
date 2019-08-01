package com.analytics.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductAnalytics {
@Id
@GeneratedValue(strategy =GenerationType.AUTO)
private int productCountId;
private int count;

@ManyToOne(cascade = CascadeType.ALL)
private Products products;

@ManyToOne(cascade = CascadeType.ALL)
private UserDetails userdetails;

public int getProductCountId() {
	return productCountId;
}
public void setProductCountId(int productCountId) {
	this.productCountId = productCountId;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}

}
