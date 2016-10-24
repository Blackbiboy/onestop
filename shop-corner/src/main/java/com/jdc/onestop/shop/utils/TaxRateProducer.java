package com.jdc.onestop.shop.utils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@ApplicationScoped
public class TaxRateProducer {

	@Named
	@Produces
	private double taxRate;
	
	@PostConstruct
	private void init() {
		
		String str = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("shop.taxRate");
		taxRate = Double.parseDouble(str);
	}
}
