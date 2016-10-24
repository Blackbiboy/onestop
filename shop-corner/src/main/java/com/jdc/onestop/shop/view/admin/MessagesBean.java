package com.jdc.onestop.shop.view.admin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Question;
import com.jdc.onestop.shop.repository.QuestionRepo;

@Named
@ViewScoped
public class MessagesBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Question> questionList;
	@Inject
	private QuestionRepo questionRepo;
	
	@PostConstruct
	private void init(){
		
	}
	
	public List<Question> getQuestionList() {
		return questionList;
	}
	
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	
	
	
}
