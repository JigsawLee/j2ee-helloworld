package com.tutorialspoint.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tutorialspoint.Student;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet arg0, int arg1) throws SQLException {
		Student student = new Student();
		student.setId(arg0.getInt("id"));
		student.setName(arg0.getString("name"));
		student.setAge(arg0.getInt("age"));
		return student;
	}

}
