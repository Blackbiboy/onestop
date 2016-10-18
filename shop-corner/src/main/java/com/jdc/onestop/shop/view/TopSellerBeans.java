package com.jdc.onestop.shop.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

import com.jdc.onestop.shop.entity.Product;

@Model
public class TopSellerBeans {
	
	private List<Product> products;
	
	@PostConstruct
	private void init() {
		
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
