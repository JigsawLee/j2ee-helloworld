package com.tutorialspoint;

public class HelloChinese {
	private String message;
	private String message1;

	public void getMessage1() {
		System.out.println("Your Message1 : " + message1);
	}

	public void setMessage1(String message1) {
		this.message1 = message1;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		System.out.println("Your Message : " + message);
	}

	public void init() {
		System.out.println("bean init");
	}

	public void destory() {
		System.out.println("bean destory");
	}
}
