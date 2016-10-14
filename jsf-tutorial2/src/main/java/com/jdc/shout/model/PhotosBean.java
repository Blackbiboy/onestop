package com.jdc.shout.model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.shout.entity.Account;
import com.jdc.shout.entity.Post;
import com.jdc.shout.entity.Smile;
import com.jdc.shout.model.converter.ModelView;
import com.jdc.shout.model.converter.ParameterHelper;
import com.jdc.shout.service.PostService;

@ModelView
public class PhotosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Post> allPost;
	
	@Inject
	private PostService service;
	
	@Inject
	private ParameterHelper params;
	
	@Named
	@Inject
	private Account loginUser;
	
	@PostConstruct
	private void init() {
		
		String catId = params.getParameter("cat");
		
		if(null != catId && !catId.isEmpty()) {
			allPost = service.findByCategory(Integer.parseInt(catId));
		} else {
			allPost = service.getAll();
		}
	}
	
	public void like(Post post) {
		Smile smile = new Smile();
		smile.setAccount(loginUser);
		post.addSmile(smile);
		
		service.update(post);
		
		init();
	}

	public List<Post> getAllPost() {
		return allPost;
	}

	public void setAllPost(List<Post> allPost) {
		this.allPost = allPost;
	}
}
