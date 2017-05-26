package com.springmvc.todo;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("nameParam")
public class TodoController {
	
	//variable to hold the APP view home directory for request mapping
	private static String appView = "todoview";
	
	// Set the TODO Service using dependency injection as an Auto-Wired
	@Autowired
	TodoService todoService;
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named login
	 */
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET) //using the request mapping of"/list-todos" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	public String showTodos(ModelMap model) {
		
		model.addAttribute("todos", todoService.retrieveTodos("amine89"));
		
		//the returned page name
		return appView+"/list-todos";
	}
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named todo
	 */
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET) //using the request mapping of"/add-todo" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	public String showAddTodo(ModelMap model) {
		
		//The model being added here corresponds with the commandName="todo" spring form binding tag on the todo "view"
		model.addAttribute("todo", new Todo(0, "amine89", "", new Date(), false));
		
		//the returned page name
		return appView+"/todo";	
	}
	
	
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named todo
	 */
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST) //using the request mapping of"/add-todo" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	//public String addTodo(ModelMap model, @RequestParam String desc) { you can use the @RequestParam to pass param or pass an entire object	
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()){
			return appView+"/todo";
		}
		todoService.addTodo("amine89", todo.getDesc(), new Date(), false);
		model.clear();
		//the returned page name
		return "redirect:/list-todos";	//return to the list todos after a new item is added by using the redirect directive
	}
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named list-todo
	 */
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET) //using the request mapping of"/add-todo" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	public String deleteTodo(ModelMap model, @RequestParam int id) {
				
		todoService.deleteTodo(id);
		model.clear();
		//the returned page name
		return "redirect:/list-todos";	//return to the list todos after a new item is added by using the redirect directive
	}
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named list-todo
	 */
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET) //using the request mapping of"/add-todo" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	public String updateTodo(ModelMap model, @RequestParam int id) {
				
		Todo todo = todoService.retrieveTodo(id);
		model.addAttribute(todo);
		
		//the returned page name
		return appView+"/todo";	//return to the list todos after a new item is added by using the redirect directive
	}
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named list-todo
	 */
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST) //using the request mapping of"/add-todo" the servlet finds and executes the showListTodosPage method using the controller "TodoController"
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		//update the todo
		if(result.hasErrors()){
			return appView+"/todo";
		}
		todo.setUser("amine89");
		
		todoService.updateTodo(todo);
		
		//the returned page name
		return "redirect:/list-todos";	//return to the list todos after a new item is added by using the redirect directive
	}
}
