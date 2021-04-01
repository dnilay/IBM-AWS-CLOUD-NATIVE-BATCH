package com.example.demo.service;

import com.example.demo.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    public List<Todo> getAllTodos();
    public Todo createTodo(Todo todo);
}
