package com.jdc.onestop.shop.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jdc.onestop.shop.entity.Member;

public class MemberRepo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;

	public void add(Member member) {
		em.persist(member);
	}

	public Member find(String loginId) {
		return em.find(Member.class, loginId);
	}

	public void save(Member member) {
		em.merge(member);
	}

}
