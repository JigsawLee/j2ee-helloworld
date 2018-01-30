package com.tutorialspoint.jdbc;

import java.util.List;

import javax.sql.DataSource;

import com.tutorialspoint.Student;

public interface StudentDao {
	public void setDataSource(DataSource ds);

	public void create(String name, Integer age);

	public Student getStudent(Integer id);

	public List<Student> listStudents();

	public void delete(Integer id);

	public void update(Integer id, Integer age);

}
