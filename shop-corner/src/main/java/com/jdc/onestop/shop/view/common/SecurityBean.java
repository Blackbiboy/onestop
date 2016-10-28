package com.jdc.onestop.shop.view.common;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Member.Role;
import com.jdc.onestop.shop.service.MemberService;

@Model
public class SecurityBean {
	
	private String name;
	private String login;
	private String password;
	
	@Inject
	private MemberService service;
	
	@Inject
	private Event<Member> event;
	
	public String signOut() {
		try {
			
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "/home?faces-redirect=true";
			
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("", "Please check login id and password!");
			FacesContext.getCurrentInstance().addMessage(null, message);
			e.printStackTrace();
		}
		
		return "/home";
	}
	
	public String signIn() {
		
		try {
			internalLogin();
			
			Member member = service.findById(login);
			event.fire(member);
			
			if(member.getRole() == Role.Admin) {
				return "/admin/home?faces-redirect=true";
			} else {
				
				if(null == member.getContact()) {
					return "/member/profile?faces-redirect=true";
				} else {
					return "/member/home?faces-redirect=true";
				}
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("", "Please check login id and password!");
			FacesContext.getCurrentInstance().addMessage(null, message);
			e.printStackTrace();
		}
		
		return "";
	}

	public String signUp() {
		
		try {
			
			Member member = new Member();
			member.setName(name);
			member.setLoginId(login);
			member.setPassword(password);
			service.addMember(member);
			
			internalLogin();
			event.fire(member);
			
			return "/member/profile?faces-redirect=true";
		
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("", "Please check login id!");
			FacesContext.getCurrentInstance().addMessage(null, message);
			e.printStackTrace();
		}
		
		return "/home";
	}

	private void internalLogin() throws ServletException {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		request.login(login, password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
