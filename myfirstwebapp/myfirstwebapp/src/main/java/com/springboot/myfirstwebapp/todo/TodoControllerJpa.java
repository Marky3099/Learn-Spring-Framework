package com.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	
	private TodoRepository todoRepository;

	
	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}


	@RequestMapping("todo")
	public String index(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<ToDo> todos = todoRepository.findByUsername(username);
		model.put("todos", todos);
		return "allTodo";
	}

	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String todoForm(ModelMap model) {
		String username = getLoggedInUsername(model);
		ToDo todo = new ToDo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "addTodo";
	}
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addTodo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:todo";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		todoRepository.deleteById(id);
		return "redirect:todo";
	}
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String editTodo(@RequestParam int id, ModelMap model) {
		ToDo todo = todoRepository.findById(id).get();
		model.addAttribute("todo",todo);
		return "addTodo"; 
	}
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addTodo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:todo";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
