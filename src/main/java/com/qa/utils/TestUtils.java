package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;


public class TestUtils extends TestBase{
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(prop.getProperty("TEST_DATA_SHEET_PATH"));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch(IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		System.out.println(sheet.getLastRowNum());
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i = 0; i < sheet.getLastRowNum(); i++) {
			for(int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				System.out.println(sheet.getRow(i+1).getCell(j).toString());
				data[i][j] =  sheet.getRow(i+1).getCell(j).toString();
			}	
		}
		return data;
	}
	
	public static void takeScreenshot() {
		TakesScreenshot sc = (TakesScreenshot)driver;
		File source = sc.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Screenshots/"+System.currentTimeMillis()+"order_history.png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
