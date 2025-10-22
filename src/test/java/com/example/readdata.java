package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class readdata {

	public static void main(String[] args) throws IOException {
		File filepath = new File("test data/testdata.xlsx");
		FileInputStream fle = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fle);
		XSSFSheet sheet = workbook.getSheetAt(0);
		 int rows =  sheet.getPhysicalNumberOfRows();
		
		for(int i = 1; i < rows; i++) {
			
			String username = ExcelUtils.getCellValueAsString(sheet.getRow(i).getCell(1));
			String password = ExcelUtils.getCellValueAsString(sheet.getRow(i).getCell(2));
			String expected = ExcelUtils.getCellValueAsString(sheet.getRow(i).getCell(3));
			System.out.println("User Name: " + username + "|Password: " + password + "| Expected Result" + expected);
			
		}
		
		
	
}}
