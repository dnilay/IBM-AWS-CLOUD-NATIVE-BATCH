package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Employee;

@Controller
@RequestMapping("/employees")
public class Employeecontroller {

	@GetMapping("/list")
	public String listEmployees(Model theModel)
	{
		Employee employee=new Employee(1, "John", "Doe", "john@email.com");
		Employee employee1=new Employee(2, "Marry", "Public", "marry@email.com");
		List<Employee> employeeList=new ArrayList<Employee>();
		employeeList.add(employee);
		employeeList.add(employee1);
		theModel.addAttribute("employees",employeeList);
		return "employee-list";
		
	}
}
