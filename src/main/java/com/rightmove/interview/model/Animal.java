package com.rightmove.interview.model;

public abstract class Animal {
	
	private long id;
	private String firstName;
	private String lastName;
	
	
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
		
}
