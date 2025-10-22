//package com.example;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.DataProvider;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class Data {
//	@DataProvider(name = "loginData")
//	public static Object[][] getData() throws IOException {
//		File filepath = new File("test data/testdata.xlsx");
//		FileInputStream fle = new FileInputStream(filepath);
//		XSSFWorkbook workbook = new XSSFWorkbook(fle);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		 int rows =  sheet.getPhysicalNumberOfRows();
//		 ArrayList<Object[]> data = new ArrayList<>();
//		for(int i = 1; i < rows; i++) {
//			
//			String username = sheet.getRow(i).getCell(1).getStringCellValue();
//			String password = sheet.getRow(i).getCell(2).getStringCellValue();
//			String expected = sheet.getRow(i).getCell(3).getStringCellValue();
//			System.out.println("User Name: " + username + "|Password: " + password + "| Expected Result" + expected);
//			data.add(new Object[]{username, password});
//		}
//		 return data.toArray(new Object[0][]);	
//	
//}}






package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "loginData")
    public static Object[][] getData() throws IOException {
        File file = new File("test data/testdata.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getPhysicalNumberOfRows();
        ArrayList<Object[]> data = new ArrayList<>();

        for (int i = 1; i < rows; i++) { // skip header
            Row row = sheet.getRow(i);
            if (row == null) {  
                continue; // skip empty rows
            }

            // Safe way to read cells
            String username = getCellValue(row, 1);
            String password = getCellValue(row, 2);

            if (username.isEmpty() && password.isEmpty()) {
                continue; // skip completely blank rows
            }

            data.add(new Object[]{username, password});
        }

        workbook.close();
        fis.close();

        return data.toArray(new Object[0][]);
    }

    // Utility to safely get cell value as String
    private static String getCellValue(Row row, int cellIndex) {
        if (row.getCell(cellIndex) == null) {
            return "";
        }

        Cell cell = row.getCell(cellIndex);

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue()); // handles numeric passwords
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case BLANK:
                return "";
            default:
                return cell.toString();
        }
    }
}
