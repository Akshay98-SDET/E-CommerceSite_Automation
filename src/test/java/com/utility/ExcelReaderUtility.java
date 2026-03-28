package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojos.User;

public class ExcelReaderUtility {
	public static Iterator<User> readExcelDataFile(String FileName) {

		File file = new File(System.getProperty("user.dir") + "//testData//"+FileName);
		XSSFWorkbook xssfWorkbook = null;
		try {
			xssfWorkbook = new XSSFWorkbook(file);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFSheet xssfSheet = xssfWorkbook.getSheet("logindata");
		Iterator<Row> rowIterator = xssfSheet.iterator();

		List<User> userList = new ArrayList<User>();
		Row row;
		Cell emailidCell;
		Cell passwordCell;
		User user;

		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			emailidCell = row.getCell(0);
			passwordCell = row.getCell(1);
			user = new User(emailidCell.toString(), passwordCell.toString());
			userList.add(user);
		}
		try {
			xssfWorkbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();
	}
	
}
