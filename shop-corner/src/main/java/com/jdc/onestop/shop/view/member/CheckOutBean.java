package com.jdc.onestop.shop.view.member;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.repository.OrderDetailsRepo;

@Named
@ViewScoped
public class CheckOutBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private OrderDetailsRepo repo;
	
	@PostConstruct
	private void init(){
		
	}
	
	public void confirm(){
		
	}
}
