package com.tutorialspoint.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.tutorialspoint.Student;

public class StudentJDBCTemplate implements StudentDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public void create(String name, Integer age) {
		// TODO Auto-generated method stub
		String sql = "insert into Student (name,age) values (?,?)";
		jdbcTemplate.update(sql, name, age);
		System.out.println("Create Record Name = " + name + " Age = " + age);
	}

	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from Student where id = ?";
		Student student = jdbcTemplate.queryForObject(sql, new Object[] { id }, new StudentMapper());
		return student;

	}

	public List<Student> listStudents() {
		// TODO Auto-generated method stub
		String sql = "select * from Student";
		List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
		return students;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from Student whrer id=?";
		jdbcTemplate.update(sql, id);
		System.out.println("Delete record with id = " + id);
	}

	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		String sql = "update Student set age = ? where id = ?";
		jdbcTemplate.update(sql, age, id);
		System.out.println("Updated record with id = " + id);

	}

}
