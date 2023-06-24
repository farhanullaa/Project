package com.mylearning.example.demo1;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
public class coursecontroller {
	
    @RequestMapping( method = {RequestMethod.GET}, value = "/courses")
	public List<courseConfiguration> retriveAllCourses(){
		return Arrays.asList(
				new courseConfiguration(1, "Learn AWS", "FarhanUlla"),
				new courseConfiguration(2, "Learn M pharma", "Tasmiya"),
				new courseConfiguration(3, "Learn D pharma", "Tasssu")
				);
	}
	@GetMapping(value = "/")
	public String home(){
		String str = "Farhanulla";
		return str;
	}
	
}
