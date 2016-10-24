package com.jdc.onestop.shop.utils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Order.Status;
import com.jdc.onestop.shop.entity.Product.Size;

@ApplicationScoped
public class CommonProducer {

	@Named
	@Produces
	private Status [] orderStatuses;
	
	@Named
	@Produces
	private Member.Status [] memberStatuses;
	
	@Named
	@Produces
	private Size [] sizes;
	
	@PostConstruct
	private void init() {
		orderStatuses = Status.values();
		memberStatuses = Member.Status.values();
		sizes = Size.values();
	}
}
