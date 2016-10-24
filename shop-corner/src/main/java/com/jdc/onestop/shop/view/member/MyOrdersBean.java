package com.jdc.onestop.shop.view.member;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.repository.OrderRepo;
import com.jdc.onestop.shop.service.OrderService;

@Named
@ViewScoped
public class MyOrdersBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private OrderRepo orderRepo; 

	private OrderService orderServ;
	
	@PostConstruct
	private void init(){
		
	}
	
}
