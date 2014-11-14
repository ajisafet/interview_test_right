package com.rightmove.interview.model;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.rightmove.inteview.model.Animal;
import com.rightmove.inteview.model.Human;

@RunWith(JUnitParamsRunner.class)
public class HumanTest {
	
	public static Object[] assertIdTestValues() {
		
		return new Object[] {
				1, 2, 3
		};
		
	}
	
	public static Object[] assertIllegalIdTestValues() {
		
		return new Object[] {
				0, -1, -2, -3
		};
		
	}
	
	public static Object[] assertValidFirstNamesTestValues() {
		return new Object[] {
			"Tope", "James", "Calista"	
		};
	}
	
	public static Object[] assertInvalidFirstNamesTestValues() {
		
		return new Object[] {
			""
		};
		
	}
	
	@Test
	public void humanChildOfAnimalClassTest() {
		
		Object human = new Human();
		
		
		assertTrue("Human is not a subclass of Animal class", human instanceof Animal);
		
	}
	
	@Test
	@Parameters(method = "assertIdTestValues")
	public void assertIdTestWithValue(long i) {
		
		Animal animal = new Human();
		animal.setId(i);
		assertEquals(i + " expected but actual value: " + animal.getId(), i, animal.getId());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "assertIllegalIdTestValues")
	public void assertIdTestIfLessThanOrEqualToZero(long id) {
	
		Animal animal = new Human();
		animal.setId(id);
		
	}
	
	@Test
	@Parameters(method="assertValidFirstNamesTestValues")
	public void checkFirstNameValidNameTest(String firstName) {
		
		Animal animal = new Human();
		animal.setFirstName(firstName);
		assertEquals("Error! First Name field is wrong. Expected value: " + firstName
		+ ", Actual value: " + animal.getFirstName(), firstName, animal.getFirstName());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "assertInvalidFirstNamesTestValues")
	public void checkFirstNameInvalidNameTest(String firstName) {
		
		Animal animal = new Human();
		animal.setFirstName(firstName);
		/*assertEquals("Error! First Name field is wrong. Expected value: " + firstName
		+ ", Actual value: " + animal.getFirstName(), firstName, animal.getFirstName());*/
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkFirstNameNullNameTest(String firstName) {
		
		Animal animal = new Human();
		animal.setFirstName(null);
				
	}
	
	@Test
	public void setLastNameTest(){
		
		Animal animal = new Human();
		animal.setLastName("Ajisafe");
		assertEquals("Expected: Ajisafe, Actual: " +  animal.getLastName(), "Ajisafe", animal.getLastName());
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setLastNameWithEmptyStringValueTest(){
		
		Animal animal = new Human();
		animal.setLastName("");
			
	}
	
}
