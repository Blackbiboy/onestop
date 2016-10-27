package com.jdc.onestop.shop.view.admin;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Question;

@Named
@RequestScoped
public class MessageBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Question question;

	
	@PostConstruct
	private void init(){
		
	}
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
