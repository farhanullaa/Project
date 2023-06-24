package com.example.firstapi.demo.crudspring.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyResourceIT {
	
	@Autowired
	private TestRestTemplate template;
	
	String Str = """
			{
				  "id": "Question1",
				  "description": "Most Popular Cloud Platform Today",
				  "options": [
				    "AWS",
				    "Azure",
				    "Google Cloud",
				    "Oracle Cloud"
				  ],
				  "correctAnswer": "AWS"
				}

							""";
	
    private static String SPECIFIC_QUESTION_URL ="/surveys/Survey1/questions/question1";
	
	@Test
	void retriveSpecifcSurveyQuestions_BasicDetails() {
		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);
       String ecpectedResponse="""
       		{"id":"Question1","description":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"}
       		""";
		assertEquals(ecpectedResponse, responseEntity.getBody());
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		System.out.println(responseEntity.getBody());
		System.out.println(responseEntity.getHeaders());
		
	}

}
