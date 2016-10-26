package com.jdc.onestop.shop.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jdc.onestop.shop.entity.Price;

public class PriceRepo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void add(Price price) {
		em.persist(price);
	}

}
