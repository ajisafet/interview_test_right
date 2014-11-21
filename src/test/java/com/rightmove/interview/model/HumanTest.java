package com.rightmove.interview.model;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class HumanTest {
	
	public static Object[] validLastNames() {
		
		return new Object[] {"Ajisafe",
			"Welsh",
			"Hill"
		};
		
	}
	
	@Test
	public void humanChildOfAnimalClassTest() {
		
		Object human = new Human();
		
		
		assertTrue("Human is not a subclass of Animal class", human instanceof Animal);
		
	}

	@Test
	@Parameters(method = "validLastNames")
	public void setLastNameWithValidValuesTest(String lastName){
		
		Human human = new Human();
		human.setLastName(lastName);
		assertEquals("Expected: " + lastName + ", Actual: " +  human.getLastName(), lastName, human.getLastName());
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setLastNameWithEmptyStringValueTest(){
		
		Human human = new Human();
		human.setLastName("");
			
	}
	
}
