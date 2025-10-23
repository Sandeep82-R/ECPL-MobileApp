package com.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelUtils {
	public static String getCellValueAsString(Cell cell) {
		
		if(cell == null) {
			return "";
		}
		
		CellType type = cell.getCellType();
		switch(type) {
		case STRING:
			return cell.getStringCellValue();
		
		case NUMERIC:
			return String.valueOf((long) cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case BLANK:
			return "";
		default:
			return cell.toString();
		
		}
		
		
	}

}
