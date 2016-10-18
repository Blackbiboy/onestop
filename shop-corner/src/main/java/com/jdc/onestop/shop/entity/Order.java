package com.jdc.onestop.shop.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import javax.persistence.JoinColumn;
import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name="order_tbl")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	public Order() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Temporal(TIMESTAMP)
	private Date oderDate;

	@ManyToOne
	@JoinColumn(name = "member")
	private Member member;

	@Temporal(DATE)
	private Date wishDate;

	private int subTotal;

	private int tax;

	private int total;

	@Enumerated
	private Status status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOderDate() {
		return oderDate;
	}

	public void setOderDate(Date oderDate) {
		this.oderDate = oderDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getWishDate() {
		return wishDate;
	}

	public void setWishDate(Date wishDate) {
		this.wishDate = wishDate;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public enum Status {
		Accept, Cance, Delivered, Finish
	}

}