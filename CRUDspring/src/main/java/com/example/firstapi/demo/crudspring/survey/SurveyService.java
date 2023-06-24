package com.example.firstapi.demo.crudspring.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {

	private static List<Survey> surveys = new ArrayList<>();

	static {
		Question question1 = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2", "Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3", "Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");
		Question question4 = new Question("Question4", "Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Docker");

		List<Question> questions1 = new ArrayList<>(Arrays.asList(question1, question2, question3));
		List<Question> questions2 = new ArrayList<>(Arrays.asList(question3, question4));

		Survey survey1 = new Survey("Survey1", "My Favorite Survey1", "Description of the Survey", questions1);
		Survey survey2 = new Survey("Survey2", "My Favorite Survey2", "Description of the Survey", questions2);

		surveys.add(survey1);
		surveys.add(survey2);
	}

	public List<Survey> retriveAllSurveys() {
		// TODO Auto-generated method stub
		return surveys;
	}

	public Survey retriveSurveyById(String SurveyById) {

		Predicate<? super Survey> predicate = survey -> survey.getId().equals(SurveyById);

		Optional<Survey> optionalsurvey = surveys.stream().filter(predicate).findFirst();

		if (optionalsurvey.isEmpty())
			return null;

		return optionalsurvey.get();
	}

	public List<Question> retriveAllSurveyQuestions(String surveyById) {

		Survey survey = retriveSurveyById(surveyById);
		if (survey == null)
			return null;

		// TODO Auto-generated method stub
		return survey.getQuestions();
	}

	public Question retriveSpecifcSurveyQuestions(String surveyById, String questionId) {
		
		List<Question> surveyQuestions = retriveAllSurveyQuestions(surveyById);
		if(surveyQuestions==null)  return null;
		
		Optional <Question> optionalQuestion =  surveyQuestions.stream().filter(q -> q.getId().
				equalsIgnoreCase(questionId)).findFirst();
		
		if(optionalQuestion.isEmpty()) return null;
		return optionalQuestion.get();
	}

	public String addNewSurveyQuestion(String surveyById, Question question) {
		List<Question> questions = retriveAllSurveyQuestions(surveyById);
		question.setId(GenerateRandomId());
		questions.add(question);
		
		return question.getId();
	}

	private String GenerateRandomId() {
		SecureRandom secureRandom = new SecureRandom();
		String randomId =new BigInteger(32, secureRandom).toString();
		return randomId;
	}
	
	public String deleteSurveyQuestions(String surveyById, String questionId) {
		
		List<Question> surveyQuestions = retriveAllSurveyQuestions(surveyById);
		if(surveyQuestions==null)  return null;
		
		Predicate<? super Question> predicate = q -> q.getId().
				equalsIgnoreCase(questionId);
		
		boolean removed = surveyQuestions.removeIf(predicate);
		
		if(!removed)  return null;
		
		return questionId;
	}

	public void updateSurveyQuestions(String surveyById, String questionId, Question question) {
		List<Question> questions = retriveAllSurveyQuestions(surveyById);
		questions.removeIf(q -> q.getId().equalsIgnoreCase(questionId));
		questions.add(question);
	}



}
