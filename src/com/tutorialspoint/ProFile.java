package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ProFile {
	@Autowired
	@Qualifier("student1")
	private Student student;

	public void printAge() {
		System.out.println(student.getAge());
	}
}
