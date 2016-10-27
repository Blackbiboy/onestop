package com.jdc.onestop.shop.view.member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.OrderDetails;

@Named
@SessionScoped
public class MyCartBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<OrderDetails> orders;
	
	@Named
	@Inject
	private double taxRate;

	@PostConstruct
	private void init(){
		orders = new ArrayList<>();
	}
	
	public void delete(OrderDetails od) {
		orders.remove(od);
	}
	
	public void countUp(OrderDetails od) {
		od.setCount(od.getCount() + 1);
		od.calculate();
	}
	
	public void clear() {
		this.orders.clear();
	}
	
	public void countDown(OrderDetails od) {
		od.setCount(od.getCount() - 1);
		if(od.getCount() == 0) {
			orders.remove(od);
		}
		od.calculate();
	}
	
	public void addToCart(OrderDetails order) {
		orders.add(order);
	}
	
	public int getItemCount() {
		return orders.stream().mapToInt(a -> a.getCount()).sum();
	}

	public List<OrderDetails> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetails> orders) {
		this.orders = orders;
	}
	
	public int getSubTotal() {
		return orders.stream().mapToInt(a -> a.getSubTotal()).sum();
	}
	
	public int getTax() {
		int subTotal = getSubTotal();
		Double tax = subTotal * taxRate;
		return tax.intValue();
	}
	
	public int getTotal() {
		return getSubTotal() + getTax();
	}
	
}
