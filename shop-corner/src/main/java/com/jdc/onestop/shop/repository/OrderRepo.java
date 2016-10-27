package com.jdc.onestop.shop.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Order;

public class OrderRepo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	public void add(Order order) {
		em.persist(order);
	}

	public void update(Order order) {
		em.merge(order);
	}

	public List<Order> find(Member member) {
		TypedQuery<Order> q = em.createNamedQuery("Order.findByMember", Order.class);
		q.setParameter("member", member);
		return q.getResultList();
	}

}
