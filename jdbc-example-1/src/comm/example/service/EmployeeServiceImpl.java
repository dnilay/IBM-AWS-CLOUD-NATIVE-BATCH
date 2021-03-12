package comm.example.service;

import java.sql.Connection;
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

}
