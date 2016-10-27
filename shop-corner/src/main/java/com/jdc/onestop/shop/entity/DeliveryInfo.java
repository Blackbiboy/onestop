package com.jdc.onestop.shop.entity;

import com.jdc.onestop.shop.entity.Member;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: DiliveryInfo
 *
 */
@Entity

public class DeliveryInfo implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String phone;
	private String address;
	@ManyToOne
	private Member member;
	private static final long serialVersionUID = 1L;

	public DeliveryInfo() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
		if(null != member.getContact()) {
			this.phone = member.getContact().getPhone();
			this.address = member.getContact().getAddress();
		}
	}
   
}
