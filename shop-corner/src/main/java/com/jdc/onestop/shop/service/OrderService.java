package com.jdc.onestop.shop.service;

import java.io.Serializable;
import java.util.List;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Order;

public interface OrderService extends Serializable{

	void save(Order order);

	List<Order> find(Member loginUser);

}
