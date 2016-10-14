package com.jdc.shout.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jdc.shout.entity.Account;

public class AccountRepository implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	public void add(Account ac) {
		em.persist(ac);
	}
	
	public Account findById(String loginId) {
		return em.find(Account.class, loginId);
	}
}
