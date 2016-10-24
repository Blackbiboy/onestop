package com.jdc.onestop.shop.view.admin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.repository.MemberRepo;

@Named
@ViewScoped
public class MembersBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Member> memList;
	@Inject
	private MemberRepo memRepo;
	
	@PostConstruct
	private void init(){
		
	}

	public List<Member> getMemList() {
		return memList;
	}

	public void setMemList(List<Member> memList) {
		this.memList = memList;
	}
	
	
}
