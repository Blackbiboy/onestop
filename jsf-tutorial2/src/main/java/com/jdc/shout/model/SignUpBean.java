package com.jdc.shout.model;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.jdc.shout.entity.Account;
import com.jdc.shout.service.AccountService;

@Model
public class SignUpBean {
	
	private Account account;
	
	@Inject
	private AccountService service;
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@PostConstruct
	private void init() {
		account = new Account();
	}
	
	public String signOut() {
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		ctx.invalidateSession();
		return "/photos?faces-redirect=true";
	}
	
	public String signUp() {
		
		try {
			
			String pass = account.getPassword();
			
			// persist account
			service.signUp(account);
			
			// internal login
			internalLogin(account.getLoginId(), pass);
			
			return "photos.xhtml?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("", e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "signup";
		}
		
	}

	private void internalLogin(String loginId, String pass) {
		try {
			
			ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest) ctx.getRequest();
			request.login(loginId, pass);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Please check Login ID and Password!");
		}
	}

}
