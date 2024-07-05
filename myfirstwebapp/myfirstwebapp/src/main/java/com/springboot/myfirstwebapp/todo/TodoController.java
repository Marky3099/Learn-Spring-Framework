package com.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class TodoController {
	
	private ToDoService todoService;
	
	
	
	public TodoController(ToDoService todoService) {
		super();
		this.todoService = todoService;
	}



	@RequestMapping("todo")
	public String index(ModelMap model) {
		List<ToDo> todos = todoService.findByUserName("marky");
		model.put("todos", todos);
		return "allTodo";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String todoForm(ModelMap model) {
		String username = (String)model.get("name");
		ToDo todo = new ToDo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "addTodo";
	}
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addTodo";
		}
		
		String username = (String)model.get("name");
		todoService.addToDo(username,todo.getDescription(),LocalDate.now().plusYears(1), false);
		return "redirect:todo";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		todoService.deleteById(id);
		return "redirect:todo";
	}
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String editTodo(@RequestParam int id, ModelMap model) {
		ToDo todo = todoService.findById(id);
		model.addAttribute("todo",todo);
		return "addTodo"; 
	}
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addTodo";
		}
		
		String username = (String)model.get("name");
		todoService.updateTodo(todo);
		return "redirect:todo";
	}
	
}
