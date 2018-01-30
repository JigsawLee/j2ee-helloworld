package com.tutorialspoint.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tutorialspoint.event.CustomEventPublisher;

public class EventTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		CustomEventPublisher publisher = context.getBean(CustomEventPublisher.class);
		publisher.publish();
	}
}
