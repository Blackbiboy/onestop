package com.jdc.onestop.shop.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Order;
import com.jdc.onestop.shop.entity.Order.Status;

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

	public Order findById(int orderNumber) {
		return em.find(Order.class, orderNumber);
	}

	public List<Order> find(Status status, Date searchDate) {
		
		StringBuffer sql = new StringBuffer("select o from Order o ");
		Map<String, Object> params = new HashMap<>();
		
		if(status != null) {
			sql.append("where ").append("o.status = :status ");
			params.put("status", status);
		}
		
		if(searchDate != null) {
			if(params.size() > 0) {
				sql.append("and ");
			} else {
				sql.append("where ");
			}
			
			sql.append("o.oderDate >= :orderDate");
			params.put("orderDate", searchDate);
		}
		
		TypedQuery<Order> q = em.createQuery(sql.toString(), Order.class);
		
		for(String key : params.keySet()) {
			q.setParameter(key, params.get(key));
		}
		
		return q.getResultList();
	}

}
