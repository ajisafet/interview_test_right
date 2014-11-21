package com.rightmove.interview.model;

import java.util.Date;

public abstract class Animal {
	
	private long id;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private Date dateOfBirth;
	
	
	public void setId(long id) throws IllegalArgumentException{
		
		if (id <= 0) {
		
			throw new IllegalArgumentException();
		
		}
		
		this.id = id;
		
	}

	public long getId() {
		
		return id;
		
	}

	public void setFirstName(String firstName) {
		
		if (firstName == null || firstName.equals("")) {
			
			throw new IllegalArgumentException();
			
		}
		
		
		
		this.firstName = firstName;
		
	}

	public String getFirstName() {
		
		return firstName;
		
	}

	public void setLastName(String lastName) {
	
		this.lastName = lastName;
		
	}

	public String getLastName() {
		
		return lastName;
	}

	public void setGender(String gender) {
		
		this.gender = gender;
		
	}

	public String getGender() {
		
		return gender;
		
	}

	public void setAge(int age) throws IllegalArgumentException {
		
		if (age < 0) {
			throw new IllegalArgumentException();
		}
		
		this.age = age;
		
	}

	public int getAge() {
		
		return age;
		
	}

	public void setDateOfBirth(Date dateOfBirth) {
		
		this.dateOfBirth = dateOfBirth;
		
	}

	public Date getDateOfBirth() {
		
		return dateOfBirth;
		
	}
		
}
