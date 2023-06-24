package com.example.firstapi.demo.crudspring.survey;

import java.util.List;

public class Question {
	
	private String id;
	private String description;
	private List<String> options;
	private String CorrectAnswer;
	
	public Question() {
		
	}
	
	public Question(String id, String description, List<String> options, String correctAnswer) {
		super();
		this.id = id;
		this.description = description;
		this.options = options;
		CorrectAnswer = correctAnswer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public List<String> getOptions() {
		return options;
	}

	public String getCorrectAnswer() {
		return CorrectAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + ", options=" + options + ", CorrectAnswer="
				+ CorrectAnswer + "]";
	}
	
	
	
	

}
