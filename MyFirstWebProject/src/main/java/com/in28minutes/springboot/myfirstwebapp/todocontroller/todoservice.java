package com.in28minutes.springboot.myfirstwebapp.todocontroller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class todoservice {

	private static List<todo> todos = new ArrayList<>();
	private static int todocount=0;
	
	static {
		todos.add(new todo(++todocount, "farhan ulla", "Learn java spring boot", LocalDate.now().plusYears(1), false));
		todos.add(new todo(++todocount, "tasmiya khanum", "Learn java spring core", LocalDate.now().plusYears(2), false));
		todos.add(new todo(++todocount, "choti tassu", "Learn java spring framework", LocalDate.now().plusYears(3), false));
	}
	
	public List<todo> findByusername(String username){
		Predicate<? super todo> predicate = todo->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate date, boolean done ) {
		todo Todo = new todo(++todocount, username ,description, date, done);
		todos.add(Todo);
	}
	public void deletById(int id)
	{
		Predicate<? super todo> predicate = todo->todo.getId() == id;
		todos.removeIf(predicate);
	}

	public static todo findById(int id) {
		Predicate<? super todo> predicate = todo->todo.getId() == id;
		todo Todo = todos.stream().filter(predicate).findFirst().get();
		return Todo;
	}

	public void updatetodo(@Valid todo Todo) {
		// TODO Auto-generated method stub
		deletById(Todo.getId());
		todos.add(Todo);
	}

}
