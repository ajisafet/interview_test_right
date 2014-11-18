package com.rightmove.interview.model;

import junitparams.JUnitParamsRunner;

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class PetTest {
	
	//Pet pet = new Pet();
	
	@Test
	public void petChildOfAnimalClassTest() {
		
		Object pet = new Pet();
		
		
		assertTrue("Pet is not a subclass of Animal class", pet instanceof Animal);
		
	}
	
	@Test
	public void setLastNameTest() {
		
		Animal animal = new Pet();
		animal.setLastName("");
		assertEquals("", animal.getLastName());
		
	}

}
