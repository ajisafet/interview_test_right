package com.rightmove.interview.model;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class PetTest {
	
	public static Object[] getValidOwnerIdValues() {
		
		return new Object[]{
			0, 5, 6 , 1000	
		};
		
	}
	
	public static Object[] getInvalidOwnerIdValues() {
		
		return new Object[]{
			-1, -5, -6 , -1000	
		};
		
	}
	
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
	
	@Test
	public void checkDefaultOwnerIdValueTest() {
		
		Pet pet = new Pet();
		
		assertEquals("Expected default owner value is: 0 but the actual value is: " + pet.getOwnerId(), 0, pet.getOwnerId());
		
	}
	
	@Test
	@Parameters(method = "getValidOwnerIdValues")
	public void setOwnerIdWithValidValueTest(int ownerId) {
		
		//int id = 5;
		Pet pet = new Pet();
		pet.setOwnerId(ownerId);
		assertEquals("Expected owner id value is " + ownerId +" but the actual value is " + pet.getOwnerId(), ownerId, pet.getOwnerId());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidOwnerIdValues" )
	public void setOwnerIdWithInvalidIdValueTest(int ownerId) {
		
		Pet pet = new Pet();
		pet.setOwnerId(ownerId);
		
	}

}
