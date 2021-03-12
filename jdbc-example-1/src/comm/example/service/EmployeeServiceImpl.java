package comm.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comm.example.factory.ConnectionFactory;
import comm.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	private List<Employee> employees;
	private Connection connection;
	
	{
		employees=new ArrayList<Employee>();
	}

	@Override
	public List<Employee> getAllEmployees()throws SQLException {
		// TODO Auto-generated method stub
		connection=ConnectionFactory.getMyConnection();
		ResultSet rs;
		Statement statement=connection.createStatement();
		ResultSet resultset=statement.executeQuery("select * from employees");
		while(resultset.next())
		{
			employees.add(new Employee(resultset.getInt("id"),resultset.getString("first_name"),resultset.getString("last_name")
					,resultset.getString("email"), resultset.getInt("salary"),resultset.getInt("bonus")));
		}
		return employees;
	}

	@Override
	public Employee createEmployee(Employee employee)throws SQLException {
		// TODO Auto-generated method stub
		connection=ConnectionFactory.getMyConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into employees(id,first_name,last_name,email,salary,bonus) values"
				+ "(?,?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getFirstName());
		preparedStatement.setString(3, employee.getLastName());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setInt(5, employee.getSalary());
		preparedStatement.setInt(6, employee.getBonus());
		preparedStatement.executeUpdate();
		return employee;
	}

}
