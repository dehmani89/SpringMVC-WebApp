package com.springmvc.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service		//using the @Service annotation makes the TodoService class available as a bean
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	/**
	 * Add 3 items to the list statically
	 */
	static {
		todos.add(new Todo(1, "amine89", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "amine89", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "amine89", "Learn Hibernate", new Date(), false));
	}

	/**
	 * retrieve the todo list for a particlular id
	 * @param user
	 * @return filteredTodos
	 */
	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}

	/**
	 * Add a to do item
	 * @param name
	 * @param desc
	 * @param targetDate
	 * @param isDone
	 */
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}

	/**
	 * delete a to do item
	 * @param id
	 */
	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}
	
	public Todo retrieveTodo(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	

}
