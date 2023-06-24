package com.in28minutes.springboot.myfirstwebapp.todocontroller;

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

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class todocontroller {

	private todoservice todoService;

	public todocontroller(todoservice todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAlltodos(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<todo> todos = todoService.findByusername(username);
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
		todoService.addTodo(username, todo.getDescription(), todo.getDate(), false);
		return "redirect:list-todos";

	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deletById(id);
		return "redirect:list-todos";

	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		todo Todo = todoservice.findById(id);
		model.addAttribute("Todo", Todo);
		return "todo";

	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid todo T1odo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}

		String username = getLoggedInUsername(model);
		T1odo.setUsername(username);
		todoService.updatetodo(T1odo);
		return "redirect:list-todos";

	}
}
