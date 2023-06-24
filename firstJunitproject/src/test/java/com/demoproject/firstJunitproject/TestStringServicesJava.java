package com.demoproject.firstJunitproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

import org.junit.Test;

public class TestStringServicesJava {

	StringServicesJava stringServicesJavaObject = new StringServicesJava();
	
	@DisplayName("Test check for Isogram")
	@Test
	public void testCheckForIsogram() {
		assertEquals(false, stringServicesJavaObject.checkIsogram("GeekForGeek"));
		assertEquals(true, stringServicesJavaObject.checkIsogram("algorithm"));
		assertEquals(false, stringServicesJavaObject.checkIsogram("datastructures"));
		assertEquals(false, stringServicesJavaObject.checkIsogram("machinelearning"));
		assertEquals(true, stringServicesJavaObject.checkIsogram("importance"));
	}
	
	@DisplayName("Test check for Panagram")
	@Test
	public void testCheckForPanagram() {
		assertEquals(true, stringServicesJavaObject.checkPanagram("AbCDefGhIJklmnoPQRStuvWXyZ234"));
		assertEquals(true, stringServicesJavaObject.checkPanagram("Pack my box with five dozen liquor jugs"));
		assertEquals(true, stringServicesJavaObject.checkPanagram("Waltz, bad nymph, for quick jigs vex"));
		assertEquals(false, stringServicesJavaObject.checkPanagram("machinelearning"));
		assertEquals(false, stringServicesJavaObject.checkPanagram("importance"));
	}
	
	@DisplayName("Test check for Anagram")
	@Test
	public void testCheckForAnagram() {
		assertEquals(true, stringServicesJavaObject.checkAnagram("Listen","silent"));
		assertEquals(false, stringServicesJavaObject.checkAnagram("geeksforgeeks","geeks"));
		assertEquals(true, stringServicesJavaObject.checkAnagram("a gentleman", "elegant man"));
		assertEquals(true, stringServicesJavaObject.checkAnagram("geeksforgeeks","forgeeksgeeks"));
		assertEquals(true, stringServicesJavaObject.checkAnagram("angel","glean"));
	}

}

