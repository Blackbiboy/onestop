package com.jdc.home.service;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jdc.home.domain.Member;

@SuppressWarnings("serial")
@LocalBean
@Stateless
public class MemberService implements Serializable {
	
	@Inject
	private EntityManager em;

	public Member find(String loginId) {
		return em.find(Member.class, loginId);
	}

	public void create(Member member) {
		em.persist(member);
	}

	public void save(Member loginUser) {
		em.merge(loginUser);
	}

}
