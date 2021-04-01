package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TodoDto;
import com.example.demo.feign.TodoFeignClient;

@RestController
public class ClientController {

	private TodoFeignClient todoFeignClient;

	@Autowired
	public ClientController(TodoFeignClient todoFeignClient) {
		super();
		this.todoFeignClient = todoFeignClient;
	}

	@PostMapping("/clients")
	public ResponseEntity<?> createTodo(@RequestBody TodoDto todoDto)
	{
		
		return ResponseEntity.status(HttpStatus.CREATED).body(todoFeignClient.createTodoFromClient(todoDto));
	}
	
	@GetMapping("/clients")
	public ResponseEntity<?> displayAllTodos()
	{
		return ResponseEntity.ok(todoFeignClient.displayTodosFromclient());
	}
}
