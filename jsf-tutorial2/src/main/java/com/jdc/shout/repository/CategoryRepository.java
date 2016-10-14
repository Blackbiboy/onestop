package com.jdc.shout.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jdc.shout.entity.Category;

@ApplicationScoped
public class CategoryRepository  {
	
	@Inject
	private EntityManager em;

	public List<Category> findAll() {
		return em.createQuery("select c from Category c", Category.class).getResultList();
	}
	
	public Category findById(int id) {
		return em.find(Category.class, id);
	}
}
