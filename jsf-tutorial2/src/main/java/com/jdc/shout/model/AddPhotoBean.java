package com.jdc.shout.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import com.jdc.shout.entity.Account;
import com.jdc.shout.entity.Post;
import com.jdc.shout.model.converter.ModelView;
import com.jdc.shout.service.PostService;

@ModelView
public class AddPhotoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Post post;
	private Part file;
	private String imageUrl;
	@Named
	@Inject
	private Account loginUser;
	
	@Inject
	private PostService service;
	
	@PostConstruct
	private void init() {
		post = new Post();
		post.setOwner(loginUser);
	}
	
	
	public String upload() {
		post.setImage(imageUrl);
		service.add(post);
		return "/photos.xhtml?faces-redirect=true";
	}

	public void uploadFile() {
		try {
			
			FileHelper helper = new FileHelper(file.getSubmittedFileName());
			
			BufferedImage buff = ImageIO.read(file.getInputStream());
			
			ImageIO.write(buff, helper.extension, helper.imageFile);
			
			imageUrl = helper.imageFile.getName();
			System.out.println(imageUrl);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	class FileHelper {
		File imageFile;
		String extension;
		
		FileHelper(String originalName) {
			String imageDir = FacesContext.getCurrentInstance()
					.getExternalContext().getRealPath("/image");
			
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String temp = df.format(new Date());
			
			String [] array = originalName.split("\\.");
			extension = array[array.length - 1];
			
			imageFile = new File(imageDir, temp + "." + extension);
		}
	}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public Part getFile() {
		return file;
	}
	
	public void setFile(Part file) {
		this.file = file;
	}
	
	
}
