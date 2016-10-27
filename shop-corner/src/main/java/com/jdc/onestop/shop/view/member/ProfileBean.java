package com.jdc.onestop.shop.view.member;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Contact;
import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.service.MemberService;

@Model
public class ProfileBean {
	
	@Named("loginUser")
	@Inject
	private Member member;
	
	//private Member searchMember;
	
	private Contact contact;
	
	@Inject
	private MemberService service;
	
	@PostConstruct
	private void init() {
		contact = new Contact();
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public String save() {
		
		member.setContact(contact);
		service.save(member);
		
		return "/member/home?faces-redirect=true";
	}

	public String edit(){
		
		service.edit(member);
		
		return "/member/home?faces-redirect=true";
	}
}
