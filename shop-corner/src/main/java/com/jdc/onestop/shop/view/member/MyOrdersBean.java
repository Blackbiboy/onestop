package com.jdc.onestop.shop.view.member;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Order;
import com.jdc.onestop.shop.service.OrderService;

@Named
@ViewScoped
public class MyOrdersBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private OrderService orderServ;
	
	@Named
	@Inject
	private Member loginUser;
	
	private List<Order> orders;
	
	@PostConstruct
	private void init(){
		orders = orderServ.find(loginUser);
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
