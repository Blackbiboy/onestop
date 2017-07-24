package com.jdc.home.beans;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.jdc.home.domain.Member;
import com.jdc.home.service.MemberService;
import com.jdc.home.utils.PasswordUtils;

@Model
public class SecurityBean {

	private String name;
	private String loginId;
	private String password;
	private String oldPassword;
	private String phone;
	private String email;
	
	@Inject
	private MemberService service;
	
	@Named
	@Inject
	private Member loginUser;
	
	@Inject
	private Event<String> loginEvent;
	
	public String login() {
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			request.login(loginId, password);
			loginEvent.fire(loginId);
			return "/member/profile?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("", "Please check your Login Information.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";
	}
	
	public String signUp() {
		try {
			Member member = new Member();
			member.setName(name);
			member.setLoginId(loginId);
			member.setPassword(PasswordUtils.encrpit(password));
			member.setPhone(phone);
			member.setEmail(email);
			
			service.create(member);
			
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			request.login(loginId, password);
			loginEvent.fire(loginId);
			return "/member/profile?faces-redirect=true";

		} catch (Exception e) {
			FacesMessage message = new FacesMessage("", "Please check your Login Information.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";
	}
	
	public String changePass() {

		try {
			
			if(!loginUser.getPassword().equals(PasswordUtils.encrpit(oldPassword))) {
				FacesMessage message = new FacesMessage("", "Please check your current password.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
			
			loginUser.setPassword(PasswordUtils.encrpit(password));
			service.save(loginUser);

			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			request.logout();
			
			request.login(loginId, password);
			loginEvent.fire(loginId);
			return "/member/profile?faces-redirect=true";

		} catch (Exception e) {
			FacesMessage message = new FacesMessage("", "Change Password Fails");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
