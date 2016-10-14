package com.jdc.shout.service.imp;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.jdc.shout.entity.Category;
import com.jdc.shout.entity.Post;
import com.jdc.shout.repository.CategoryRepository;
import com.jdc.shout.repository.PostRepository;
import com.jdc.shout.service.PostService;

@Local
@Stateless
public class PostServiceImp implements PostService {

	private static final long serialVersionUID = 1L;
	@Inject
	private PostRepository repo;
	@Inject
	private CategoryRepository catRepo;
	
	@Override
	public void add(Post post) {
		repo.add(post);
	}

	@Override
	public List<Post> getAll() {
		return repo.getAllPost();
	}

	@Override
	public List<Post> findByCategory(int catId) {
		Category cat = catRepo.findById(catId);
		return repo.findByCategory(cat);
	}

	@Override
	public void update(Post post) {
		repo.update(post);
	}

}
