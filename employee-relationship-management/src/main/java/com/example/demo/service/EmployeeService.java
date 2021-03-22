package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	
	public Employee createEmployee(Employee employee);
	public Employee findById(int theId); 

}
