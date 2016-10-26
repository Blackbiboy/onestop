package com.jdc.onestop.shop.view.common;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Product;
import com.jdc.onestop.shop.service.ProductService;
import com.jdc.onestop.shop.utils.ParamsHelper;

@Named
@ViewScoped
public class ProductDetailsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Product product;

	@Inject
	private ProductService service;

	@PostConstruct
	private void init() {
		String stId = ParamsHelper.getParam("id");
		if (null != stId) {
			product = service.findProductById(Integer.parseInt(stId));
		}

	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
