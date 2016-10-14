package com.jdc.shout.model.converter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@RequestScoped
public class ParameterHelper {
	
	private ExternalContext ctx;
	
	@PostConstruct
	private void init() {
		ctx = FacesContext.getCurrentInstance().getExternalContext();
	}

	public String getParameter(String key) {
		return ctx.getRequestParameterMap().get(key);
	}
}
