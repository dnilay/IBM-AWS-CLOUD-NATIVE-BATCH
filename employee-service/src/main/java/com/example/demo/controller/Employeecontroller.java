package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class Employeecontroller {
	private EmployeeService employeeService;

	@Autowired
	public Employeecontroller(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping(path = "/employees", produces = "application/json")
	public ResponseEntity<Collection<Employee>> findAllEmployee() {

		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee());
	}
	
	@GetMapping(path = "/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
	}
}