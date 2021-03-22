package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class Employeecontroller {
	
	private EmployeeService employeeService;

	@Autowired
	public Employeecontroller(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String getEmployees(Model model)
	{
		List<Employee> list=employeeService.getAllEmployee();
		model.addAttribute("employees", list);
		return "list-employees";
	}
	

}
