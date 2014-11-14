package com.rightmove.inteview.model;


public class Human extends Animal{
	
	public void setLastName(String lastName) throws IllegalArgumentException{
		
		if (lastName.equals("")) {
			
			throw new IllegalArgumentException();
			
		}
		
		super.setLastName(lastName);
		
	}
	
}
