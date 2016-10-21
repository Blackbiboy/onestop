package com.jdc.onestop.shop.view.cart;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Order;
import com.jdc.onestop.shop.entity.OrderDetails;
import com.jdc.onestop.shop.entity.Product;
import com.jdc.onestop.shop.service.ProductService;

@SessionScoped
public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Named("loginUser")
	@Inject
	private Member member;
	
	@Named
	@Inject
	private double taxRate;
	
	private Set<OrderDetails> orders;
	private Date wishDate;
	
	@Inject
	private ProductService service;
	
	@PostConstruct
	private void init() {
		orders = new LinkedHashSet<>();
	}
	
	public Date getWishDate() {
		return wishDate;
	}
	
	public void setWishDate(Date wishDate) {
		this.wishDate = wishDate;
	}
	
	public Set<OrderDetails> getOrders() {
		return orders;
	}
	
	public void setOrders(Set<OrderDetails> orders) {
		this.orders = orders;
	}
	
	public void add(Product product) {
		OrderDetails order = orders.stream().filter(a -> a.getProduct().getId() == product.getId()).findAny().orElse(new OrderDetails());
		
		if(order.getId() == 0) {
			order.setProduct(product);
			order.setCount(1);
			order.setUnitPrice(service.getPrice(product));
			order.setSubTotal(order.getCount() * order.getUnitPrice());
		} else {
			order.setCount(order.getCount() + 1);
			order.setSubTotal(order.getCount() * order.getUnitPrice());
		}
		orders.add(order);
	}

	public Order getOrder() {
		
		Order order = new Order();
		
		order.setMember(member);
		order.setWishDate(wishDate);
		order.setOrders(orders);
		order.calculate(taxRate);
		
		return order;
	}
}
