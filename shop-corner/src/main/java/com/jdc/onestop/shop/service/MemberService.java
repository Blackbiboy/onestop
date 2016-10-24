package com.jdc.onestop.shop.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Member.Status;

@Local
@Stateless
public interface MemberService extends Serializable{
	
	void addMember(Member member);
	
	Member findById(String loginId);

	void save(Member member);

	List<Member> search(Status status, String name);

}
