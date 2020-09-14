package com.apache.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataDrvienUsingTestNG {
	public static String dir = System.getProperty("user.dir");
	String fileName = this.getClass().getSimpleName();
	
	@BeforeClass
	public void ReadData(){
		System.out.println(dir);
		File f = new File(dir+"//TestResults//"+fileName+".xlsx");
		if(f.exists()) f.delete();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet(fileName+" Results");
	    XSSFRow rowhead = spreadsheet.createRow((short)0);
	    rowhead.setHeightInPoints((2*spreadsheet.getDefaultRowHeightInPoints()));
	    CellStyle style = workbook.createCellStyle();
	    
	    style.setFillForegroundColor(IndexedColors.VIOLET.getIndex());
	     
	    XSSFFont font = workbook.createFont();
	    font.setColor(IndexedColors.WHITE.getIndex());
	    font.setBold(true);
	    style.setFont(font);
	  
	    rowhead.createCell(0).setCellValue("TestCase ID");
	    rowhead.createCell(1).setCellValue("TestCaseDescription");
	    rowhead.createCell(2).setCellValue("ScenarioType");
	    rowhead.createCell(3).setCellValue("Input Response/Data");
	    rowhead.createCell(4).setCellValue("WS Status");
	    rowhead.createCell(5).setCellValue("WS Status Code");
	    rowhead.createCell(6).setCellValue("WS Response");
	    rowhead.createCell(7).setCellValue("TestResult");
	    rowhead.createCell(8).setCellValue("Comments");
	    
	    
	    for(int j=0; j<9; j++)
	    {
	    	rowhead.getCell(j).setCellStyle(style);
	    	spreadsheet.autoSizeColumn(j);
	    }
	    
	    FileOutputStream out;
		try {
			//out = new FileOutputStream(new File("./TestResults/"+fileName+".xlsx"));
			out = new FileOutputStream(new File(dir+"//TestResults//"+fileName+".xlsx"));
    	    workbook.write(out);
	        out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		
	}
	@Test
	public void TC_01() {
		System.out.println("done");
	}

}
