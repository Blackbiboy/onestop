package com.jdc.onestop.shop.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	public List<Member> search(String sql, Map<String, Object> params) {
		TypedQuery<Member> q = em.createQuery(sql, Member.class);
		
		for(String key : params.keySet()) {
			q.setParameter(key, params.get(key));
		}
		
		return q.getResultList();
	}
	
	public Member searchMember(Member m){
		return em.merge(m);
	}
	

}
