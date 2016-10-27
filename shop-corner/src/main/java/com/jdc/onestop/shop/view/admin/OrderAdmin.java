package com.jdc.onestop.shop.view.admin;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Order;
import com.jdc.onestop.shop.entity.Order.Status;
import com.jdc.onestop.shop.service.OrderService;
import com.jdc.onestop.shop.utils.ParamsHelper;

@Named
@ViewScoped
public class OrderAdmin implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Order order;
	private Status status;
	
	@Inject
	private OrderService service;
	
	@PostConstruct
	private void init() {
		String str = ParamsHelper.getParam("id");
		System.out.println("Parameter : " + str);
		if(null != str) {
			order = service.find(Integer.parseInt(str));
		}
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public String save() {
		order.setStatus(status);
		order.setUpdateDate(new Date());
		return "/admin/orders?faces-redirect=true";
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
