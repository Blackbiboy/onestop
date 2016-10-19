package com.jdc.onestop.shop.utils;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.service.MemberService;

public class LoginUserProducer {
	
	@Named
	@Produces
	private Member loginUser;
	
	@Inject
	private MemberService service;
	
	@PostConstruct
	private void init() {
		String loginId = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		if(null != loginId)
			loginUser = service.findById(loginId);
	}

}
