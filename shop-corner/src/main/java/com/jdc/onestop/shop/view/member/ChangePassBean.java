package com.jdc.onestop.shop.view.member;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotEmpty;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.service.MemberService;
import com.jdc.onestop.shop.utils.PasswordUtils;

@Model
public class ChangePassBean {
	
	@Named("loginUser")
	@Inject
	private Member member;
	
	@NotEmpty(message="Please enter old password!")
	private String oldPass;
	@NotEmpty(message="Please enter new password!")
	private String newPass;
	@NotEmpty(message="Please enter confirm password!")
	private String confPass;
	
	@Inject
	private MemberService service;
	
	public String save() {
		
		FacesMessage message = null;
		
		// check old password
		if(!member.getPassword().equals(PasswordUtils.encript(oldPass))) {
			message = new FacesMessage(null, "Please check your old password!");
		}
		
		// check confirm
		if(!newPass.equals(confPass)) {
			message = new FacesMessage(null, "Please enter the same new password and confirm password!");
		}
		
		if(null != message) {
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "";
		}
		
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
