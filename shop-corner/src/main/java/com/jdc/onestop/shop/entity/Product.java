package com.jdc.onestop.shop.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import static javax.persistence.FetchType.EAGER;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(value = { @NamedQuery(name = "Product.getAll", query = "select p from Product p") })
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	public Product() {
		sizes = new ArrayList<>();
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@NotEmpty(message="You must enter Product Name")
	private String name;

	@ManyToOne
	private Category category;
	private String photo;

	@Enumerated
	@ElementCollection
	@CollectionTable
	private List<Size> sizes;
	@Lob
	private String description;
	@Enumerated
	private Status status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creation;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modification;
	
	@OneToMany(mappedBy = "product", fetch = EAGER)
	private List<Price> prices;

	@PrePersist
	private void init() {
		creation = new Date();
		modification = new Date();
	}

	public enum Size {
		XS, S, M, L, XL, XXL
	}
	
	public List<Price> getPrices() {
		return prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public enum Status {
		Available, SoldOut
	}

	public List<Size> getSizes() {
		return sizes;
	}

	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	/*
	 * public String getSizesString() { StringBuffer b = new StringBuffer();
	 * List<Size> s = new ArrayList<>(sizes); for (int i = 0; i < sizes.size();
	 * i++) { if (i > 0) { b.append(", "); } b.append(s.get(i)); } return
	 * b.toString(); }
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((creation == null) ? 0 : creation.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((modification == null) ? 0 : modification.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (creation == null) {
			if (other.creation != null)
				return false;
		} else if (!creation.equals(other.creation))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (modification == null) {
			if (other.modification != null)
				return false;
		} else if (!modification.equals(other.modification))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}