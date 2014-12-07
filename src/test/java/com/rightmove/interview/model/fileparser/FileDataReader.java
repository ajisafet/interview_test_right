package com.rightmove.interview.model.fileparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rightmove.interview.model.Animal;
import com.rightmove.interview.model.Human;
import com.rightmove.interview.model.Pet;

public class FileDataReader {
	
	private List<Human> humanList;
	private List<Pet> petList;
	
	public FileDataReader() {
	
		humanList = new ArrayList<Human>();
		petList = new ArrayList<Pet>();
		
	}
	
	public List<Human> getHumanList() {
		
		return humanList;
	
	}

	public List<Pet> getPetList() {
		
		return petList;
		
	}

	public void readFile(File file) throws IOException, ParseException {
	
		FileReader filereader = null;
		BufferedReader bufferedReader = null;
		
		try {
			
			filereader = new FileReader(file);
			bufferedReader = new BufferedReader(filereader);
			readFile(bufferedReader);
		
		} finally {
						
			if (bufferedReader != null) {
				
				try {
					bufferedReader.close();
				} catch (IOException ioe) {
					
				}
			}
			
			if (filereader != null) {
				
				try {
					filereader.close();
				} catch (IOException ioe) {
					
				}
			}
			
		}
		
	}
	
	public void readFile(BufferedReader reader) throws IOException, ParseException {
		
		String s = null;
		//Animal animal = null;
		DateFormat dateFormat = null;
		Date date  = null;
		
		while ( (s=reader.readLine()) != null) {
			
			
			String[] data = s.split(",");
			
			if(data[0].trim().equalsIgnoreCase("id")) continue;
			
			if (dateFormat == null) {
				
				dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				
			}
			
			System.out.println("id: " + data[0] + "length: " + data.length);
			if (data[1].trim().equalsIgnoreCase("human")) {
				
				Human human = new Human();
				human.setId(Integer.parseInt(data[0].trim()));
				human.setGender(data[1].trim());
				human.setFirstName(data[2].trim());
				human.setLastName(data[3].trim());
				human.setGender(data[4].trim());
				human.setAge(Integer.parseInt(data[5].trim()));
				date = dateFormat.parse(data[6].trim());
				human.setDateOfBirth(date);
				humanList.add(human);
				
			} else {
				
				Pet pet = new Pet();
				pet.setId(Integer.parseInt(data[0].trim()));
				pet.setGender(data[1].trim());
				pet.setFirstName(data[2].trim());
				pet.setLastName(data[3].trim());
				pet.setGender(data[4].trim());
				pet.setAge(Integer.parseInt(data[5].trim()));
				date = dateFormat.parse(data[6].trim());
				pet.setDateOfBirth(date);
				System.out.println(data[0] + " " + data[1] + " " + data[5] + data[6]);
				
				try{
				
					if (!data[7].trim().equals("")) {
						pet.setOwnerId(Integer.parseInt(data[7].trim()));
					}
				
				} catch (ArrayIndexOutOfBoundsException aie) {
					
				}
				
				petList.add(pet);
				
			}
			
		}
		
	}

	
}
