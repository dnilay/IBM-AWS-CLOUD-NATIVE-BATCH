package org.example.service;

import java.sql.SQLException;

import org.example.model.Student;

public interface StudentService {
	
	public Student createStudent(Student student) throws SQLException;

}
