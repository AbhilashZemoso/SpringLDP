package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			
			Student theStudent = 
					mapper.readValue(
							new File("data/sample-full.json"), Student.class);
			
			System.out.println(theStudent);
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
