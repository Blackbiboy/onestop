package com.jdc.onestop.shop.view.admin;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Order;
import com.jdc.onestop.shop.entity.Order.Status;
import com.jdc.onestop.shop.service.OrderService;

@Named
@ViewScoped
public class OrdersAdminBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<Order> orders;
	
	@Inject
	private OrderService service;
	
	private Status status;
	private Date searchDate;
	private int orderNumber; 
	
	@PostConstruct
	private void init() {
		searchDate = Date.from(LocalDate.of(YearMonth.now().getYear(), YearMonth.now().getMonth(), 1)
				.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		
		if(status == null)
			status = Status.values()[0];
		
		search();
	}
	
	public void search() {
		orders = service.search(status, searchDate, orderNumber);
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

}
