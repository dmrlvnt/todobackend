package com.capgemini.todoapp.backend.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todo_id;

	private String note;
    private boolean done;
    private Timestamp createdon = Timestamp.valueOf(LocalDateTime.now());

    public Todo() {   	
    }
    
    public Todo(Long todo_id, String note, boolean done, Timestamp createdon) {
    	this.todo_id = todo_id;
        this.note = note;
        this.done = done;
        this.createdon = createdon;
    }

    public Long getTodo_id() {
		return todo_id;
	}

	public void setTodo_id(Long todo_id) {
		this.todo_id = todo_id;
	}
	
    public void setNote(String note) {
        this.note = note;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    
    public void setCreatedon(Timestamp createdon) {
        this.createdon = createdon;
    }
    
    public String getNote() {
        return note;
    }

    public boolean isDone() {
        return done;
    }
    
    public Timestamp getCreatedon() {
        return createdon;
    }
}
