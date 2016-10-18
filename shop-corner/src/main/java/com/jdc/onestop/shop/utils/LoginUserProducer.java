package com.jdc.onestop.shop.utils;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Member;

public class LoginUserProducer {
	
	@Named
	@Produces
	private Member loginUser;
	
	@PostConstruct
	private void init() {
		
	}

}
