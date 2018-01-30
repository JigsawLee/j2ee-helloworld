package com.jigsaw.mybatis.bean;

public class Person {
	private int id;
	private String address;
	private String city;

	public Person() {

	}

	public Person(int id, String address, String city) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
