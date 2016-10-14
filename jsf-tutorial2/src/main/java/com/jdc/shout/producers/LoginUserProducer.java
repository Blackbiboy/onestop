package com.jdc.shout.producers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.jdc.shout.entity.Account;
import com.jdc.shout.repository.AccountRepository;

public class LoginUserProducer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Named
	@Produces
	private Account loginUser;
	
	@Inject
	private AccountRepository repo;
	
	@PostConstruct
	private void init() {
		try {
			ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest) ctx.getRequest();
			String login = request.getRemoteUser();
			if(null != login)
				loginUser = repo.findById(login);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
