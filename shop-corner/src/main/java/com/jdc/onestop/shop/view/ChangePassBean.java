package com.jdc.onestop.shop.view;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.service.MemberService;
import com.jdc.onestop.shop.utils.PasswordUtils;

@Model
public class ChangePassBean {
	
	@Named("loginUser")
	@Inject
	private Member member;
	
	private String oldPass;
	private String newPass;
	private String confPass;
	
	@Inject
	private MemberService service;
	
	public String save() {
		
		// check inputs TODO
		
		
		member.setPassword(PasswordUtils.encript(newPass));
		service.save(member);
		
		return "/member/home?faces-redirect=true";
	}
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getOldPass() {
		return oldPass;
	}
	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	public String getConfPass() {
		return confPass;
	}
	public void setConfPass(String confPass) {
		this.confPass = confPass;
	}
	
	

}
