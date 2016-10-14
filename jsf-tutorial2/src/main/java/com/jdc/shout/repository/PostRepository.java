package com.jdc.shout.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.shout.entity.Category;
import com.jdc.shout.entity.Post;

public class PostRepository {

	@Inject
	private EntityManager em;
	
	public void add(Post post) {
		em.persist(post);
	}
	
	public List<Post> getAllPost() {
		TypedQuery<Post> q = em.createNamedQuery("Post.getAll", Post.class);
		return q.getResultList();
	}

	public List<Post> findByCategory(Category cat) {
		TypedQuery<Post> q = em.createNamedQuery("Post.findByCategory", Post.class);
		q.setParameter("cat", cat);
		return q.getResultList();
	}

	public void update(Post post) {
		em.merge(post);
	}
}
 