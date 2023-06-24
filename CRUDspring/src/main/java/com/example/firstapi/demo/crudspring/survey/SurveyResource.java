package com.example.firstapi.demo.crudspring.survey;


import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.tools.DocumentationTool.Location;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class SurveyResource {

	
	// /surveys
	// /
	
	private SurveyService surveyService; 
	
	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}

	@RequestMapping("/surveys")
	public List<Survey> retriveAllSurveys(){
		return surveyService.retriveAllSurveys();
		
	}
	
	@RequestMapping("/surveys/{SurveyById}")
	public Survey retriveSurveyById(@PathVariable String SurveyById){
		Survey survey = surveyService.retriveSurveyById(SurveyById);
		if(survey==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return survey;
	}
	
	@RequestMapping("/surveys/{SurveyById}/questions")
	public List<Question> retriveAllSurveyQuestions(@PathVariable String SurveyById){
		List<Question> questions = surveyService.retriveAllSurveyQuestions(SurveyById);
		if(questions==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return questions;
	}
	
	@RequestMapping("/surveys/{SurveyById}/questions/{QuestionId}")
	public Question retriveSpecifcSurveyQuestions(@PathVariable String SurveyById,@PathVariable String QuestionId){
		Question questions = surveyService.retriveSpecifcSurveyQuestions(SurveyById, QuestionId);
		if(questions==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return questions;
	}
	
	@RequestMapping(value ="/surveys/{SurveyById}/questions", method = RequestMethod.POST)
	public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String SurveyById, @RequestBody Question question ){
		
		String questionId = surveyService.addNewSurveyQuestion(SurveyById, question);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{questionId}").buildAndExpand(questionId).toUri();
		return ResponseEntity.created(location ).build();
		
		
	}

	
	@RequestMapping(value = "/surveys/{SurveyById}/questions/{QuestionId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSurveyQuestions(@PathVariable String SurveyById,@PathVariable String QuestionId){
		surveyService.deleteSurveyQuestions(SurveyById, QuestionId);
		
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/surveys/{SurveyById}/questions/{QuestionId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateSurveyQuestions(@PathVariable String SurveyById,@PathVariable String QuestionId, @RequestBody Question question){
		surveyService.updateSurveyQuestions(SurveyById, QuestionId, question);
		
		return ResponseEntity.noContent().build();
	}

	
}
