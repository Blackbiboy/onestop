package com.jdc.onestop.shop.view.admin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Member;
import com.jdc.onestop.shop.entity.Member.Status;
import com.jdc.onestop.shop.service.MemberService;

@Named
@ViewScoped
public class MembersBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Member> memList;
	
	@Inject
	private MemberService service;
	
	private Status status;
	private String name;
	
	@PostConstruct
	private void init(){
		search();
	}
	
	public String search() {
		memList = service.search(status, name);
		
		return "/admin/members.xhtml";
	}

	public List<Member> getMemList() {
		return memList;
	}

	public void setMemList(List<Member> memList) {
		this.memList = memList;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
