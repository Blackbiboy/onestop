package com.jdc.onestop.shop.utils;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Category;
import com.jdc.onestop.shop.repository.CategoryRepo;

@ApplicationScoped
public class CategoryProducer {
	
	@Named
	@Produces
	private List<Category> categories;
	
	@Inject
	private CategoryRepo repo;
	
	@PostConstruct
	private void init() {
		categories = repo.getAll();
	}

}
