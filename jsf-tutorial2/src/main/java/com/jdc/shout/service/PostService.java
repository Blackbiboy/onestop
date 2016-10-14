package com.jdc.shout.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.jdc.shout.entity.Post;

@Local
@Stateless
public interface PostService {

	void add(Post post);
	
	List<Post> getAll();
	
	List<Post> findByCategory(int catId);
}
