package com.jdc.onestop.shop.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.onestop.shop.entity.Product;

public class ProductRepo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;

	public void add(Product p) {
		em.persist(p);
	}

	public Product find(int id) {
		return em.find(Product.class, id);
	}

	public List<Product> getAll() {
		TypedQuery<Product> p = em.createNamedQuery("Product.getAll", Product.class);
		return p.getResultList();
	}

}
