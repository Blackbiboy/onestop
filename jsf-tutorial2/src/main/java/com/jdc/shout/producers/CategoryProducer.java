package com.jdc.shout.producers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.shout.entity.Category;
import com.jdc.shout.repository.CategoryRepository;

@ApplicationScoped
public class CategoryProducer {
	
	@Named
	@Produces
	private List<Category> categories;
	
	@Inject
	private CategoryRepository repo;
	
	@PostConstruct
	private void init() {
		categories = repo.findAll();
	}

}
