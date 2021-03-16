package org.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.example.model.Student;

public class StudentServiceImpl implements StudentService {
	
	private DataSource dataSource;
	

	public StudentServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	@Override
	public Student createStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=dataSource.getConnection();
		PreparedStatement pStatement=connection.prepareStatement("insert into student(id,first_name,last_name,email)"
				+ "values(?,?,?,?)");
		pStatement.setInt(1, student.getId());
		pStatement.setString(2, student.getFirstName());
		pStatement.setString(3, student.getLastName());
		pStatement.setString(4, student.getEmail());
		pStatement.executeUpdate();
		return student;
	}

}
