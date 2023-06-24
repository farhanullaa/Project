package com.example.firstapi.demo.crudspring.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@WebMvcTest(controllers = SurveyResource.class)
class SurveyResourceTes {

	@MockBean
	SurveyService surveyService;

	@Autowired
	private MockMvc mockMvc;

	private static String SPECIFIC_URL = "http://localhost:8080/surveys/Survey1/questions/Question1";

	private static String GENERIC_URL = "http://localhost:8080/surveys/Survey1/questions";

	@Test
	void retriveSpecifcSurveyQuestions_basicSceniros() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(SPECIFIC_URL).accept(MediaType.APPLICATION_JSON);

		Question question = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");

		when(surveyService.retriveSpecifcSurveyQuestions("Survey1", "Question1")).thenReturn(question);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		String expectedResponse = """
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
		MockHttpServletResponse response = mvcResult.getResponse();
		assertEquals(200, response.getStatus());
		JSONAssert.assertEquals(expectedResponse, response.getContentAsString(), false);
		System.out.println(response.getStatus());
		System.out.println(response);

	}

	@Test
	void addNewSurveyQuestion_basic() throws Exception {
		String Requestbody = """
							{
				  "id": "Question1",
				  "description": "Most Popular Cloud Platform Today",
				  "options": [
				    "Java",
				    "Python",
				    "Google Cloud",
				    "Oracle Cloud"
				  ],
				  "correctAnswer": "JAVA"
				}
				""";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(GENERIC_URL).
				accept(MediaType.APPLICATION_JSON).content(Requestbody).contentType(MediaType.APPLICATION_JSON);

		when(surveyService.addNewSurveyQuestion(anyString(), any())).thenReturn("SOME_ID");
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		String LocationHeader = response.getHeader("location");
		System.out.println(response.getStatus());
		System.out.println(LocationHeader);
		assertEquals(201, response.getStatus());
		assertTrue(LocationHeader.contains("/surveys/Survey1/questions/SOME_ID"));

	}

	@Test
	void retriveSpecifcSurveyQuestions_404Sceniros() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(SPECIFIC_URL).accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(mvcResult.getResponse().getStatus());

	}

}
