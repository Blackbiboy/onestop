package com.jdc.onestop.shop.utils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Order.Status;

@ApplicationScoped
public class CommonProducer {

	@Named
	@Produces
	private Status [] orderStatuses;
	
	@PostConstruct
	private void init() {
		orderStatuses = Status.values();
	}
}
