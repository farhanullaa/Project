package com.springboot.myfirstwebapp.todojpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.myfirstwebapp.todocontroller.todo;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class todocontrollerJpa {

	public todocontrollerJpa(todoRepository todorepository) {
		super();

		this.todorepository = todorepository;
	}

	private todoRepository todorepository;

	@RequestMapping("list-todos")
	public String listAlltodos(ModelMap model) {
		String username = getLoggedInUsername(model);

		List<todo> todos = todorepository.findByusername(username);

		model.addAttribute("todos", todos);
		return "listTodos";

	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	@RequestMapping(value = "add-todos", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		todo T1do = new todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("Todo", T1do);
		return "todo";

	}

	@RequestMapping(value = "add-todos", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}

		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todorepository.save(todo);
		// todoService.addTodo(username, todo.getDescription(), todo.getDate(), false);
		return "redirect:list-todos";

	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todorepository.deleteById(id);
		return "redirect:list-todos";

	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		todo Todo = todorepository.findById(id).get();
		model.addAttribute("Todo", Todo);
		return "todo";

	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid todo Todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}

		String username = getLoggedInUsername(model);

		Todo.setUsername(username);
		todorepository.save(Todo);
		return "redirect:list-todos";

	}
}
