package com.rightmove.interview.model;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class AnimalTest {
	
	public static Object[] assertAgeInvalidValues() {
		
		return new Object[] {
				-1, -2, -24, -100
		};
		
	}

	public static Object[] assertAgeValidValues() {
		
		return new Object[] {
				0, 1, 2, 24, 100
		};
		
	}
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
	
	public static Object[] genderValues() {
		
		return new Object[] {
			"M",
			"F"
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
	public void setPetWithValidLastNameTest(){
		
		Animal animal = new Pet();
		animal.setLastName("Ajisafe");
		assertEquals("Expected: Ajisafe, Actual: " +  animal.getLastName(), "Ajisafe", animal.getLastName());
	
	}

	@Test
	public void setPetLastNameWithEmptyStringValueTest(){
		
		Animal animal = new Pet();
		animal.setLastName("");
		assertEquals("", animal.getLastName());
			
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setHumanLastNameWithEmptyStringValueTest(){
		
		Animal animal = new Human();
		animal.setLastName("");
		assertEquals("", animal.getLastName());
			
	}
	
	@Test
	public void setHumanLastNameWithValidValueTest(){
		
		Animal animal = new Human();
		animal.setLastName("Ajisafe");
		assertEquals("Ajisafe", animal.getLastName());
			
	}
	
	@Test
	@Parameters(method = "genderValues")
	public void setGenderTest(String gender) {
		
		Animal animal = new Human();
		animal.setGender(gender);
		assertEquals(gender, animal.getGender());
		
	}
	
	@Test
	@Parameters(method = "assertAgeValidValues")
	public void setAgeWithValidValueTest(int age) {
		
		Animal animal = new Human();
		animal.setAge(age);
		assertEquals("Expected age: " + age + ", Actual age: " + animal.getAge(), age, animal.getAge());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "assertAgeInvalidValues")
	public void setAgeWithNegativeValueTest(int age) {
		
		Animal animal = new Human();
		animal.setAge(age);
		
	}
	
	@Test
	public void setDateOfBirthTest() {
		
		Date date = new Date(System.currentTimeMillis());
		Animal animal = new Human();
		animal.setDateOfBirth(date);		
		assertEquals("Expected date: " + date + ", Actual date: " + animal.getDateOfBirth(), date, animal.getDateOfBirth());
		
	}
	
	@Test
	public void setDateOfBirthWithStringTest() throws ParseException{
		
		String dateString = "16/03/1977";
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		date = dateFormat.parse(dateString);
		Animal animal = new Human();
		animal.setDateOfBirth(date);
		assertEquals("Expected date: " + date + ", Actual date: " + animal.getDateOfBirth(), date, animal.getDateOfBirth());
		
	}
	
}
