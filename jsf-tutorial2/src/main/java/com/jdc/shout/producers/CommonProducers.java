package com.jdc.shout.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class CommonProducers {
	
	@Named
	@Produces
	private String copyRight = "\u00a9 2016 JDC All Right Reserved.";
}
