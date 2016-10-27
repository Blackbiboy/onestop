package com.jdc.onestop.shop.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import javax.persistence.JoinColumn;
import static javax.persistence.TemporalType.DATE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name="order_tbl")
@NamedQueries({
	@NamedQuery(name="Order.findByMember",
			query="select o from Order o where o.member = :member")
})
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	public Order() {
	}
	
	@PrePersist
	public void setBusinessDate() {
		oderDate = new Date();
		status = Status.Accept;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Temporal(TIMESTAMP)
	private Date oderDate;

	@ManyToOne
	@JoinColumn(name = "member")
	private Member member;
	
	@ManyToOne(cascade = { PERSIST, MERGE })
	private DeliveryInfo delivery;

	@Temporal(DATE)
	private Date wishDate;

	private int subTotal;

	private int tax;

	private int total;

	@Enumerated
	private Status status;
	
	@OneToMany(mappedBy = "order", cascade = { PERSIST, MERGE }, orphanRemoval = true, fetch = EAGER)
	private Set<OrderDetails> orders;

	public Set<OrderDetails> getOrders() {
		return orders;
	}
	
	public void setOrders(Set<OrderDetails> orders) {
		this.orders = orders;
		for(OrderDetails od : orders) {
			od.setOrder(this);
		}
	}
	
	public void calculate(double taxPercent) {
		if(null != orders) {
			subTotal = orders.stream().mapToInt(od -> od.getUnitPrice() * od.getCount()).sum();
			tax = (int)(subTotal * taxPercent);
			total = subTotal + tax;
		}
	}
	
	public DeliveryInfo getDelivery() {
		return delivery;
	}

	public void setDelivery(DeliveryInfo delivery) {
		this.delivery = delivery;
	}

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
	
	public List<OrderDetails> getOrderList() {
		return new ArrayList<>(orders);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((oderDate == null) ? 0 : oderDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + subTotal;
		result = prime * result + tax;
		result = prime * result + total;
		result = prime * result + ((wishDate == null) ? 0 : wishDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (oderDate == null) {
			if (other.oderDate != null)
				return false;
		} else if (!oderDate.equals(other.oderDate))
			return false;
		if (status != other.status)
			return false;
		if (subTotal != other.subTotal)
			return false;
		if (tax != other.tax)
			return false;
		if (total != other.total)
			return false;
		if (wishDate == null) {
			if (other.wishDate != null)
				return false;
		} else if (!wishDate.equals(other.wishDate))
			return false;
		return true;
	}

}