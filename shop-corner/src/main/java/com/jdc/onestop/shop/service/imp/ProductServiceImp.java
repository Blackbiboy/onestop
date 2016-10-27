package com.jdc.onestop.shop.service.imp;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.jdc.onestop.shop.entity.Price;
import com.jdc.onestop.shop.entity.Product;
import com.jdc.onestop.shop.entity.Product.Size;
import com.jdc.onestop.shop.repository.PriceRepo;
import com.jdc.onestop.shop.repository.ProductRepo;
import com.jdc.onestop.shop.service.ProductService;

@Local
@Stateless
public class ProductServiceImp implements Serializable, ProductService {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProductRepo repo;
	@Inject
	private PriceRepo priceRepo;

	@Override
	public int getPrice(Product product) {

		return 0;
	}

	@Override
	public Product findProductById(int id) {
		Product p = repo.find(id);
		for(Size s : p.getSizes()) {
			s.toString();
		}
		return p;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = repo.getAll();
		
		for(Product p : list) {
			for(Size s : p.getSizes()) {
				s.toString();
			}
		}
		
		return repo.getAll();
	}

	@Override
	public void add(Product p, Price price) {
		repo.add(p);
		priceRepo.add(price);
	}
}
 