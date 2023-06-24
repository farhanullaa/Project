package com.example.demo.farhanulla;

import java.util.List;

public class Stores {
	
	
	private String Id;
	private String Storename;
	private List<Pharmacy> recipt;
	private String ispresent;
	
	public String getStorename() {
		return Storename;
	}
	public List<Pharmacy> getRecipt() {
		return recipt;
	}
	public String getIspresent() {
		return ispresent;
	}
	public String getId() {
		return Id;
	}
	
	public Stores(String id, String storename, List<Pharmacy> recipt, String ispresent) {
		super();
		Id = id;
		Storename = storename;
		this.recipt = recipt;
		this.ispresent = ispresent;
	}
	@Override
	public String toString() {
		return "Stores [Id=" + Id + ", Storename=" + Storename + ", recipt=" + recipt + ", ispresent=" + ispresent
				+ "]";
	}
	

}
