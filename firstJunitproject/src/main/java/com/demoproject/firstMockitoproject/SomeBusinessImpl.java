package com.demoproject.firstMockitoproject;

public class SomeBusinessImpl {

	private DataService dataService;
	
	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatesvalue = Integer.MIN_VALUE;
		for(int value:data)
		{
			if(value> greatesvalue)
			{
				greatesvalue = value;
			}
		}
		return greatesvalue;
	}
}


interface DataService{
	int[] retrieveAllData();
	
}