package com.mylearning.example.demo1;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class currencycontroller {
	
	@Autowired
	private Currencyconfiguation config;
	
    @RequestMapping( method = {RequestMethod.GET}, value = "/farhan/currency")
	public Currencyconfiguation retriveAllCourses(){
		return config;
		
	}
}
