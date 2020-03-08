package com.demo;

import java.io.Serializable;

public class WorkModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9035607066810522366L;

	private String name;
	private int age;
	private String welcome;
	
	public WorkModel(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		this.welcome = "Hello "+name;
	}
	
	public WorkModel() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

}
