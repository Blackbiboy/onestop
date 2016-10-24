package com.jdc.onestop.shop.view.admin;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.repository.MemberRepo;
import com.jdc.onestop.shop.service.MemberService;

@Named
@RequestScoped
public class MemberBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Member member;
	@Inject
	private MemberRepo memRepo;
	@Inject
	private MemberService memServ;
	
	
}
