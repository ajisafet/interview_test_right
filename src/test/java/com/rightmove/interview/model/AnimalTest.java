package com.rightmove.interview.model;

import static org.junit.Assert.assertEquals;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class AnimalTest {
	
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
	
}
