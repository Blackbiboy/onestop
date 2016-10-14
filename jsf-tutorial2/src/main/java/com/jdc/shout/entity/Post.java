package com.jdc.shout.entity;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;

@Entity
@NamedQueries(value={
		@NamedQuery(name="Post.getAll", query="select p from Post p"),
		@NamedQuery(name="Post.findByCategory", query="select p from Post p where :cat member of p.categories ")
})
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String title;
	
	@Lob
	private String description;
	private String image;
	
	@ManyToOne
	private Account owner;
	@Temporal(TIMESTAMP)
	private Date creation;
	
	@ManyToMany(fetch = EAGER)
	@OrderBy
	private Set<Category> categories;
	@OneToMany(mappedBy = "post", orphanRemoval = true, fetch = EAGER, cascade = { PERSIST, MERGE })
	private Set<Smile> smiles;
	
	public Post() {
		categories = new HashSet<>();
		smiles = new HashSet<>();
	}
	
	@PrePersist
	private void setCreation() {
		creation = new Date();
	}
	
	public void addSmile(Smile smile) {
		smile.setPost(this);
		smiles.add(smile);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Account getOwner() {
		return owner;
	}
	public void setOwner(Account owner) {
		this.owner = owner;
	}
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public Set<Smile> getSmiles() {
		return smiles;
	}
	public void setSmiles(Set<Smile> smiles) {
		this.smiles = smiles;
	}
	
	public String getCategoryString() {
		StringBuffer sb = new StringBuffer();
		List<Category> catList = new ArrayList<>(categories);
		for(int i=0; i < catList.size(); i++) {
			if(i > 0) {
				sb.append(", ");
			}
			sb.append(catList.get(i).getName());
		}
		return sb.toString();
	}
}
