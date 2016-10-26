package com.jdc.onestop.shop.view.admin;

import java.io.Serializable;
import java.nio.file.Path;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Price;
import com.jdc.onestop.shop.entity.Product;
import com.jdc.onestop.shop.service.ProductService;

@Named
@RequestScoped
public class ProductAdminBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Product product;
	private Price price;

	private Path file;

	@Inject
	private ProductService service;

	@PostConstruct
	private void init() {
		product = new Product();
		price = new Price();
		price.setProduct(product);

		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (null != id) {
			product = service.findProductById(Integer.parseInt(id));
		}
	}

	public void uploadPhoto() {

	}

	public String add() {
		service.add(product, price);

		return "/public/product? faces-redirect=true&id=" + product.getId();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Path getFile() {
		return file;
	}

	public void setFile(Path file) {
		this.file = file;
	}

}
