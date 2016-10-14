package com.capgemini.todoapp.backend.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.todoapp.backend.model.Todo;
import com.capgemini.todoapp.backend.model.TodoDao;

@RestController
@RequestMapping("/api/backend/")
@CrossOrigin(origins = "*")
public class TodoRestController {

	@Autowired
	private TodoDao todoDao;

	@RequestMapping(method = RequestMethod.GET, value = "todos", produces = "application/json")
	public ResponseEntity<Collection<Todo>> getAllTodos(){
		return new ResponseEntity<>((Collection<Todo>) todoDao.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "todos/{id}", produces = "application/json")
	public ResponseEntity<Todo> getTodoWithId(@PathVariable Long id) {
		return new ResponseEntity<>(todoDao.findOne(id),HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "todos/{id}", produces = "application/json")
	public void removeTodo(@PathVariable Long id) {
		todoDao.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "todos", produces = "application/json")
	public ResponseEntity<?> addTodo(@RequestBody Todo todo) {
		return new ResponseEntity<>(todoDao.save(todo), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "todos/{id}", produces = "application/json")
	public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
		Todo update = todoDao.findOne(id);
	    update.setNote(todo.getNote());
	    update.setDone(todo.isDone());
	    update.setCreatedon(todo.getCreatedon());

		return new ResponseEntity<>(todoDao.save(update), HttpStatus.OK);
	}
}
