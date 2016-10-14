package com.capgemini.todoapp.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.capgemini.todoapp.backend.model" }) 
@EnableJpaRepositories(basePackages = { "com.capgemini.todoapp.backend.model" })
public class TodoappSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoappSpringbootApplication.class, args);
	}
}
