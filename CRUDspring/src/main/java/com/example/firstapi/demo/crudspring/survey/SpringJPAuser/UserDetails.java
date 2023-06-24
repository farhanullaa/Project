package com.example.firstapi.demo.crudspring.survey.SpringJPAuser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userDetails")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_Id")
	private Long Id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="role")
	private String role;
	
	
	public UserDetails(Long id, String name, String role) {
		super();
		Id = id;
		this.name = name;
		this.role = role;
	}
	public Long getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	@Override
	public String toString() {
		return "UserDetails [Id=" + Id + ", name=" + name + ", role=" + role + "]";
	}
	
	
	

}
