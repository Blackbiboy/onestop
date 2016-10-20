package com.jdc.onestop.shop.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import static javax.persistence.EnumType.STRING;
import javax.persistence.Temporal;

import com.jdc.onestop.shop.utils.PasswordUtils;

import static javax.persistence.TemporalType.TIMESTAMP;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;

@Entity
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	public Member() {
	}

	@Id
	private String loginId;

	private String name;

	private String password;

	@OneToOne(mappedBy = "member", cascade = { PERSIST, MERGE }, orphanRemoval = true)
	private Contact contact;

	private String photo;

	@Enumerated(STRING)
	private Role role;

	@Temporal(TIMESTAMP)
	private Date creation;

	@Temporal(TIMESTAMP)
	private Date modification;

	@PrePersist
	private void setSecurity() {
		role = Role.Member;
		creation = new Date();
		modification = new Date();
		password = PasswordUtils.encript(password);
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
		contact.setMember(this);
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
		Admin, Member
	}

}