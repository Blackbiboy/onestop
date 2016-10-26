package com.jdc.onestop.shop.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.jdc.onestop.shop.entity.Price;
import com.jdc.onestop.shop.entity.Product;

@Local
@Stateless
public interface ProductService extends Serializable {
	int getPrice(Product product);

	public void add(Product p, Price price);

	public Product findProductById(int id);

	public List<Product> getAllProduct();

}
