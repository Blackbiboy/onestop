package com.jdc.home.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@SuppressWarnings("serial")
public class Member implements Serializable {

	@Id
	@NotEmpty(message="Please enter login Id")
	private String loginId;
	@NotEmpty(message="Please enter password")
	private String password;
	@NotEmpty(message="Please enter Name")
	private String name;
	@NotEmpty(message="Please enter Phone Number")
	private String phone;
	private String email;
	private String greeting;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@PrePersist
	private void init() {
		role = Role.Member;
	}
	
	public enum Role {
		Admin, Member;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
