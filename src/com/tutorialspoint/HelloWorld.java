package com.tutorialspoint;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloWorld {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		System.out.println("Your Message : " + message);
	}

	@PostConstruct
	public void init() {
		System.out.println("bean init");
	}

	@PreDestroy
	public void destory() {
		System.out.println("bean destory");
	}
}
