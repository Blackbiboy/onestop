package com.jdc.onestop.shop.service;

import java.io.Serializable;

import com.jdc.onestop.shop.entity.Product;

public interface ProductService extends Serializable{
	int getPrice(Product product);
}
