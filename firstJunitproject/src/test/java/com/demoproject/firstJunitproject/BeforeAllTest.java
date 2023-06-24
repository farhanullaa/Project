package com.demoproject.firstJunitproject;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.*;

//import org.junit.Test;

public class BeforeAllTest {
	
	@BeforeAll
	public static void inti()
	{
		System.out.println("Before All test");
	}
		
	@RepeatedTest(5)
	public void addNumber(RepetitionInfo repetitionInfo) {
		System.out.println("Running test -> " + repetitionInfo.getCurrentRepetition());
		
		Assertions.assertEquals(2, Calculator.add(1, 1), "Result=");
	}

}
