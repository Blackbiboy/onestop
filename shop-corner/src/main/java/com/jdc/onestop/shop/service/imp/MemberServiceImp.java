package com.jdc.onestop.shop.service.imp;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.repository.MemberRepo;
import com.jdc.onestop.shop.service.MemberService;

@Local
@Stateless
public class MemberServiceImp implements MemberService {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MemberRepo repo;

	@Override
	public void addMember(Member member) {
		repo.add(member);
	}

	@Override
	public Member findById(String loginId) {
		return repo.find(loginId);
	}

	@Override
	public void save(Member member) {
		repo.save(member);
	}

}
