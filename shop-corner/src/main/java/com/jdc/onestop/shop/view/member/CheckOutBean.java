package com.jdc.onestop.shop.view.member;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.annotation.PostConstruct;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.DeliveryInfo;
import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Order;
import com.jdc.onestop.shop.service.OrderService;

@Named
@FlowScoped("checkout")
public class CheckOutBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private DeliveryInfo delivery;
	
	private Date deliveryDate;
	
	@Named
	@Inject
	private double taxRate;
	
	@Named
	@Inject
	private Member loginUser;
	
	@Inject
	private MyCartBean cart;
	
	@Inject
	private OrderService service;
	
	@PostConstruct
	private void init(){
		delivery = new DeliveryInfo();
		delivery.setMember(loginUser);
		deliveryDate = Date.from(LocalDateTime.now().plusDays(3).atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public String confirm(){
		
		// create order
		Order order = new Order();
		
		// set member
		order.setMember(loginUser);
		
		// delivery
		order.setDelivery(delivery);
		
		// set order details
		order.setOrders(new LinkedHashSet<>(cart.getOrders()));
		
		// set wish date
		order.setWishDate(deliveryDate);
		
		// calculate with tax rate
		order.calculate(taxRate);
		
		// add to db
		service.save(order);
		
		// clear cart
		cart.clear();
		
		return "/member/home?faces-redirect=true";
	}

	public DeliveryInfo getDelivery() {
		return delivery;
	}

	public void setDelivery(DeliveryInfo delivery) {
		this.delivery = delivery;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public Member getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Member loginUser) {
		this.loginUser = loginUser;
	}

	public MyCartBean getCart() {
		return cart;
	}

	public void setCart(MyCartBean cart) {
		this.cart = cart;
	}
}
