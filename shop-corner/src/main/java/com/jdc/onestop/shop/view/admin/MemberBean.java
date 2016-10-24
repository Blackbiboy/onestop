package com.jdc.onestop.shop.view.admin;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.service.MemberService;

@Named
@RequestScoped
public class MemberBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Member member;

	@PostConstruct
	private void init() {
		String loginId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(null != loginId) {
			member = memServ.findById(loginId);
		}
	}

	@Inject
	private MemberService memServ;
	
	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}
	
}
