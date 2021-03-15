package comm.example.service;

import java.sql.SQLException;
import java.util.List;

import comm.example.exception.EmployeeNotFoundException;
import comm.example.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees() throws SQLException;
	
	public Employee createEmployee(Employee employee) throws SQLException;
	public void removeEmployeeById(int id) throws SQLException, EmployeeNotFoundException;

}
