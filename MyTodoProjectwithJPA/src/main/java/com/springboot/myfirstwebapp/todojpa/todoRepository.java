package com.springboot.myfirstwebapp.todojpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.myfirstwebapp.todocontroller.todo;

public interface todoRepository extends JpaRepository<todo, Integer> {

	public List<todo> findByusername(String username);
	
}
