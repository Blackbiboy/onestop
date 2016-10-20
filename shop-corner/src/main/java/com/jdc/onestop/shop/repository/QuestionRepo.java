package com.jdc.onestop.shop.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Question;

public class QuestionRepo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void add(Question q) {
		em.persist(q);
	}
	
	public void save(Question q) {
		em.merge(q);
	}
	
	public List<Question> findByOwner(Member member) {
		return em.createNamedQuery("Question.findByOwner", Question.class).getResultList();
	}

}
