package com.jdc.onestop.shop.service.imp;

import java.io.Serializable;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.jdc.onestop.shop.entity.Product;
import com.jdc.onestop.shop.service.ProductService;

@Local
@Stateless
public class ProductServiceImp implements Serializable, ProductService {

	private static final long serialVersionUID = 1L;

	@Override
	public int getPrice(Product product) {

		return 0;
	}
}
