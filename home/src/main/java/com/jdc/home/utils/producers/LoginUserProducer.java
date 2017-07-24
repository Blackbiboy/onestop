package com.jdc.home.utils.producers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.home.domain.Member;
import com.jdc.home.service.MemberService;

@SuppressWarnings("serial")
@SessionScoped
public class LoginUserProducer implements Serializable {

	@Named
	@Produces
	private Member loginUser;
	@Inject
	private MemberService service;
	
	public void load(@Observes String loginId) {
		loginUser = service.find(loginId);
	}
}
