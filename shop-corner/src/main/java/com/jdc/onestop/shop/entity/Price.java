package com.jdc.onestop.shop.entity;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Price implements Serializable{

	private static final long serialVersionUID = 1L;

	public Price() {
    }

	@Id
    @GeneratedValue(strategy = IDENTITY)
	private int id;

	@ManyToOne
    private Product product;

	@Temporal(TIMESTAMP)
    private Date refDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getRefDate() {
		return refDate;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

}