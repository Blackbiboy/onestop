package com.jdc.onestop.shop.view.member;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Product;
import com.jdc.onestop.shop.repository.OrderDetailsRepo;

@Named
@ViewScoped
public class MyCartBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Product> productList;
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@PostConstruct
	private void init(){
		
	}
	
	public double itemTotal(){
		return 0.0;
	}
	
	public double subTotal(){
		return 0.0;
	}
	
	public void checkout(){
		
	}
}
