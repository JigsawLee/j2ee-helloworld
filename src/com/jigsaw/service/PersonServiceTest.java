package com.jigsaw.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jigsaw.mybatis.bean.Person;

public class PersonServiceTest {

	@Test
	public void testSelectPersonById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		PersonService service = (PersonService) context.getBean("personService");
		assertNotNull(service.selectPersonById(1));
	}

}
