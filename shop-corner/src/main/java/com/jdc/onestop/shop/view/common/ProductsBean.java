package com.jdc.onestop.shop.view.common;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Product;
import com.jdc.onestop.shop.service.ProductService;

@Named
@ViewScoped
public class ProductsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Product> productList;

	@Inject
	private ProductService service;

	@PostConstruct
	private void init() {
		productList = service.getAllProduct();
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public void search() {

	}

}
