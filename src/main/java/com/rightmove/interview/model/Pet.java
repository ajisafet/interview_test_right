package com.rightmove.interview.model;

public class Pet extends Animal{
	
	private int ownerId;
	
	public int getOwnerId() {
		
		return ownerId;
		
	}

	public void setOwnerId(int ownerId) throws IllegalArgumentException{
		
		if (ownerId < 0) {
			
			throw new IllegalArgumentException();
			
		}
		
		this.ownerId = ownerId;
		
	}
	
}
