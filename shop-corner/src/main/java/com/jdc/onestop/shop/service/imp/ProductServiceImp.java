package com.jdc.onestop.shop.service.imp;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.jdc.onestop.shop.entity.Product;
import com.jdc.onestop.shop.repository.ProductRepo;
import com.jdc.onestop.shop.service.ProductService;

@Local
@Stateless
public class ProductServiceImp implements Serializable, ProductService {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProductRepo repo;

	@Override
	public int getPrice(Product product) {

		return 0;
	}

	@Override
	public void add(Product p) {
		repo.add(p);
	}

	@Override
	public Product findProductById(int id) {
		Product p = repo.find(id);
		return p;
	}

	@Override
	public List<Product> getAllProduct() {
		return repo.getAll();
	}
}
