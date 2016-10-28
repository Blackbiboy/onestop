package com.jdc.onestop.shop.view.admin;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Order;
import com.jdc.onestop.shop.service.OrderService;
import com.jdc.onestop.shop.utils.ParamsHelper;

@Named
@ViewScoped
public class OrderAdmin implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Order order;
	
	@Inject
	private OrderService service;
	
	@PostConstruct
	private void init() {
		String str = ParamsHelper.getParam("id");

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
		order.setUpdateDate(new Date());
		service.save(order);
		return "/admin/orders?faces-redirect=true";
	}

	
}
