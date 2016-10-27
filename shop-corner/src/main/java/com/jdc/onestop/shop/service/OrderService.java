package com.jdc.onestop.shop.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Order;
import com.jdc.onestop.shop.entity.Order.Status;

public interface OrderService extends Serializable{

	void save(Order order);

	List<Order> find(Member loginUser);

	List<Order> search(Status status, Date searchDate, int orderNumber);

	Order find(int id);

}
