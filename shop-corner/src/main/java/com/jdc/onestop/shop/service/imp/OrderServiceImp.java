package com.jdc.onestop.shop.service.imp;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Order;
import com.jdc.onestop.shop.repository.OrderRepo;
import com.jdc.onestop.shop.service.OrderService;

@Stateless
@Local
public class OrderServiceImp implements OrderService {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OrderRepo repo;
	
	@Override
	public void save(Order order) {
		if(order.getId() == 0) {
			repo.add(order);
		} else {
			repo.update(order);
		}
	}

	@Override
	public List<Order> find(Member member) {
		return repo.find(member);
	}

}
