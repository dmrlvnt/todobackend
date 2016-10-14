package com.capgemini.todoapp.backend.model;

import org.springframework.data.repository.CrudRepository;

public interface TodoDao extends CrudRepository<Todo, Long>{

}
