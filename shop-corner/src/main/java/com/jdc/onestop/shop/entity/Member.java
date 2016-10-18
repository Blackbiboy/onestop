package com.jdc.onestop.shop.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import static javax.persistence.EnumType.STRING;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
public class Member implements Serializable{

 	private static final long serialVersionUID = 1L;


	public Member() {
    }

	@Id
    private String loginId;

    private String name;

    private String password;

    @Enumerated(STRING)
    private Role role;

    @Temporal(TIMESTAMP)
	private Date creation;

    @Temporal(TIMESTAMP)
	private Date modification;

    
    public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Date getCreation() {
		return creation;
	}


	public void setCreation(Date creation) {
		this.creation = creation;
	}


	public Date getModification() {
		return modification;
	}


	public void setModification(Date modification) {
		this.modification = modification;
	}


	public enum Role {
        Admin,
        Member
    }

}