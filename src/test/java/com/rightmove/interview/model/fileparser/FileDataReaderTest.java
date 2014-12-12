package com.rightmove.interview.model.fileparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class FileDataReaderTest {
	
	private FileDataReader fileDataReader;
	
	@Test
	public void createFileDataReaderTest(){
		
		fileDataReader = new FileDataReader();
		assertNotNull("Human list is null when fileDataReader is instantiated", fileDataReader.getHumanList());
		assertNotNull("Pet list is null when fileDataReader is instantiated", fileDataReader.getPetList());
		
	}
	
	@Test
	public void readFileTest() throws IOException, ParseException {
		//System.out.println(System.getProperty("user.dir"));
		File file = new File("manipulate-data.txt");
		fileDataReader = new FileDataReader();
		
		fileDataReader.readFile(file);
		//verify(fileDataReader).readFile(file);
		assertEquals(6, fileDataReader.getHumanList().size());
		
	}
	
	@Test
	public void readFileSimulatedSourceTest() throws IOException, ParseException{
		
		fileDataReader = new FileDataReader();
		
		StringReader reader = new StringReader("7, Pet, Col,  , female, 16, 16/03/1987, 3\n1, Human, Jeff, Briton, male, 29, 16/03/1977\n");
		BufferedReader bufferedReader = new BufferedReader(reader);
	
		fileDataReader.readFile(bufferedReader);
		
		
		
		assertEquals("Expected human list size: 1, Actual human list size: " + fileDataReader.getHumanList().size(),
				1, fileDataReader.getHumanList().size());
		
		assertEquals("Expected pet list size: 1, Actual pet list size: " + fileDataReader.getPetList().size(),
				1, fileDataReader.getPetList().size());
		
		bufferedReader.close();
	}
	
}
