package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;


public class LoginDataProvider {

	@DataProvider (name = "LoginDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		Gson gson = new Gson();
		File file = new File(System.getProperty("user.dir") + "\\testData\\logindata.json");
		FileReader fileReader = new FileReader(file);

		TestData data = gson.fromJson(fileReader, TestData.class);

		List<Object[]> dataReturn = new ArrayList<Object[]>();

		for (User user : data.getData()) {
			dataReturn.add(new Object[] {user});
		}
		return dataReturn.iterator();
	}
	
	@DataProvider(name = "LoginCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("logindata.csv");
	}
	
	@DataProvider(name = "LoginExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelDataFile("logindata.xlsx");
	}
	

}
