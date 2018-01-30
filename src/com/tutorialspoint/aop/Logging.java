package com.tutorialspoint.aop;

public class Logging {
	public void beforeAdvice() {
		System.out.println("Goint to setup student profile.");
	}

	public void afterAdvice() {
		System.out.println("Student profile has been setup.");
	}

	public void afterReturningAdvice(Object retVal) {
		System.out.println("Returning:" + retVal.toString());
	}

	public void afterThrowingAdvice(IllegalArgumentException e) {
		System.out.println("There has been an exception");
	}
}
