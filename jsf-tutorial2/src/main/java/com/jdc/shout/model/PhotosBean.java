package com.jdc.shout.model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.shout.entity.Post;
import com.jdc.shout.model.converter.ParameterHelper;
import com.jdc.shout.service.PostService;

@Model
public class PhotosBean {

	private List<Post> allPost;
	
	@Inject
	private PostService service;
	
	@Inject
	private ParameterHelper params;
	
	@PostConstruct
	private void init() {
		
		String catId = params.getParameter("cat");
		
		if(null != catId && !catId.isEmpty()) {
			allPost = service.findByCategory(Integer.parseInt(catId));
		} else {
			allPost = service.getAll();
		}
	}

	public List<Post> getAllPost() {
		return allPost;
	}

	public void setAllPost(List<Post> allPost) {
		this.allPost = allPost;
	}
}
