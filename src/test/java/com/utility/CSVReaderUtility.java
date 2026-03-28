package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.User;

public class CSVReaderUtility {

	public static void main(String[] args) {

		File csvfile = new File(System.getProperty("user.dir") + "//testData//logindata.csv");
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;

		try {
			fileReader = new FileReader(csvfile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();
			List<User> userList = new ArrayList<User>();
			
			
			while((line = csvReader.readNext())!= null) {
				User userData = new User(line[0], line[1]);
				userList.add(userData);
			}
			
			for (User userData : userList) {
				System.out.println(userData);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
	}

}
