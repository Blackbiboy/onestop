package com.jdc.onestop.shop.view.member;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Question;

@Named
@ViewScoped
public class MyQuestionsBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Question> questionList;
	
	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public void addQuestion(){
		
	}
	
}
