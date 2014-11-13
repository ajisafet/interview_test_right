package com.rightmove.inteview.model;

public abstract class Animal {
	
	private long id;
	
	
	public void setId(long id) throws IllegalArgumentException{
		
		if (id <= 0) {
		
			throw new IllegalArgumentException();
		
		}
		
		this.id = id;
		
	}

	public long getId() {
		
		return id;
		
	}
	
	
}
