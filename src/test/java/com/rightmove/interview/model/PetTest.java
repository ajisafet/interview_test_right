package com.rightmove.interview.model;

import org.junit.*;

import com.rightmove.inteview.model.Animal;

import static org.junit.Assert.*;


public class PetTest {
	
	//Pet pet = new Pet();
	
	@Test
	public void petChildOfAnimalClassTest() {
		
		Object pet = new Pet();
		
		
		assertTrue("Pet is not a subclass of Animal class", pet instanceof Animal);
		
	}
	
	/*public Object createInstance() {
		
		return new Pet();
	}*/

}