package com.jdc.onestop.shop.utils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Order.Status;

@ApplicationScoped
public class CommonProducer {

	@Named
	@Produces
	private Status [] orderStatuses;
	
	@Named
	@Produces
	private Member.Status [] memberStatuses;
	
	@PostConstruct
	private void init() {
		orderStatuses = Status.values();
		memberStatuses = Member.Status.values();
	}
}
