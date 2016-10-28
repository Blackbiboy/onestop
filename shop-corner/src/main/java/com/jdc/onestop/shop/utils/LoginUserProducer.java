package com.jdc.onestop.shop.utils;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.service.MemberService;

@SessionScoped
public class LoginUserProducer implements Serializable {
	
	private static final long serialVersionUID = 1L;

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
	
	public void setUser(@Observes Member member) {
		this.loginUser = member;
	}

}
