package com.example.demo.farhanulla;

import java.util.List;

public class Pharmacy {
	
	private String id;
	private String name;
	private String date;
	private List<String> doctor;
	
	@Override
	public String toString() {
		return "Pharmacy [id=" + id + ", name=" + name + ", date=" + date + ", doctor=" + doctor + "]";
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDate() {
		return date;
	}
	public List<String> getDoctor() {
		return doctor;
	}
	public Pharmacy(String id, String name, String date, List<String> doctor) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.doctor = doctor;
	}
	

}
