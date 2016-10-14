package com.jdc.shout.entity;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public enum Role {Admin, Member}
	
	@Id
	@NotEmpty(message="You must enter Login Id!")
	private String loginId;
	@NotEmpty(message="You must enter Account Name!")
	private String name;
	private String email;
	private String phone;
	@NotEmpty(message="You must enter password!")
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@PrePersist
	private void hashPass() {
		
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte [] hash = digest.digest(password.getBytes());
			password = Base64.getEncoder().encodeToString(hash);
			
		} catch (Exception e) {
			throw new RuntimeException("Pass Hash Error!");
		}
		
	}
	
	public Account() {
		role = Role.Member;
	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	
}
