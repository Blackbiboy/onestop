package com.jdc.onestop.shop.service.imp;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Member.Status;
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

	@Override
	public List<Member> search(Status status, String name) {
		String sql = "select m from Member m where m.role = 'Member' ";
		StringBuffer sb = new StringBuffer();
		
		if(null != status) {
			sb.append("and m.status = :status "); 
		}
		
		if(null != name && !name.isEmpty()) {
			sb.append("and m.name like :name");
		}
		
		sql += sb.toString();
		
		return repo.search(sql);
	}

	@Override
	public Member edit(Member m){
		return repo.searchMember(m);
	}

}
