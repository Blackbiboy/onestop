package com.jdc.onestop.shop.view.admin;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.onestop.shop.entity.Order;
import com.jdc.onestop.shop.entity.Order.Status;
import com.jdc.onestop.shop.service.OrderService;

@Model
public class OrdersAdminBean {
	
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
		status = Status.values()[0];
		
		search();
	}
	
	public String search() {
		orders = service.search(status, searchDate, orderNumber);
		return "";
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
