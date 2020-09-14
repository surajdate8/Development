package com.src.excels;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	
	public static String dir = System.getProperty("user.dir");
	
	public HashMap<String, LinkedHashMap<String, String>> getTestData(String userStoryName) throws IOException {
			
		String testCaseId = null;
		String FilePath=dir+"/Test_Data.xlsx";
		HashMap<String, LinkedHashMap<String, String>> Excel = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		File inputWorkbook = new File(FilePath);
		FileInputStream fis = new FileInputStream(inputWorkbook);
		if (FilePath.toString().endsWith(".xlsx")) {
			XSSFWorkbook w = new XSSFWorkbook(fis);
			XSSFSheet sheet = w.getSheet(userStoryName);
			int rowcount = sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < rowcount; i++) {
				LinkedHashMap<String, String> list = new LinkedHashMap<String, String>();
				int columncount = sheet.getRow(i).getLastCellNum();
				String columnValue = "";
				for (int j = 0; j < columncount; j++) {
					String columnName = sheet.getRow(0).getCell(j).toString();
					
					if(sheet.getRow(i).getCell(j) == null) {
						columnValue = "";
					} else {
						columnValue = sheet.getRow(i).getCell(j).toString();
					}
					
					if (columnName.equalsIgnoreCase("TC_ID")) {
						testCaseId = columnValue;
					}
					list.put(columnName, columnValue);
				}
				Excel.put(testCaseId, list);
			}
			fis.close();
			w.close();
		}
		return Excel;
	}
	
	public void createResultExcel(String fileName)
	{
		File f = new File(dir+"/Excel_Test_Results/"+fileName+".xlsx"); 
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
			out = new FileOutputStream(new File(dir+"/Excel_Test_Results/"+fileName+".xlsx"));
    	    workbook.write(out);
    	    workbook.close();
	        out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	     
	}
	
	public void writeExcel(String fileName, String testCaseId, String testDesc, String scenarioType, String inputData,
			String wsStatus, String wsStatusCode, String wsResponse, String testResult, String Comments)
	{
		try {
			String excelFilePath = dir+"/Excel_Test_Results/"+fileName+".xlsx";
			File inputWorkbook = new File(excelFilePath);
			FileInputStream fis = new FileInputStream(inputWorkbook);
			XSSFWorkbook w = new XSSFWorkbook(fis);
			XSSFSheet sheet = w.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			Object[][] cellValues = {
					{testCaseId, testDesc, scenarioType, inputData, wsStatus, wsStatusCode,
						wsResponse, testResult, Comments}
			};
			XSSFRow row = sheet.createRow(++rowCount);
			for (Object[] a : cellValues) {
 
                int columnCount = 0;
                 
                XSSFCell cell = row.createCell(columnCount);
                 
                for (Object field : a) {                    
                    cell.setCellValue((String)field);
                    CellStyle cs = w.createCellStyle();
                    cs.setWrapText(true);
                    row.setHeight((short)-1);
                       cell.setCellStyle(cs);
                    XSSFFont font = w.createFont();
                    if(testResult.equalsIgnoreCase("Pass")) {
                    	font.setColor(IndexedColors.GREEN.getIndex());
                    }else {
                    	font.setColor(IndexedColors.RED.getIndex());
                    }
            	    font.setBold(false);
            	    cs.setFont(font);
                    cell = row.createCell(++columnCount);
                }
 
            }
			sheet.setColumnWidth(1, 6000);
			sheet.setColumnWidth(3, 9000);
			sheet.setColumnWidth(6, 9000);
			fis.close();
			 
            FileOutputStream outputStream = new FileOutputStream(dir+"/Excel_Test_Results/"+fileName+".xlsx");
            w.write(outputStream);
            w.close();
            fis.close();
            outputStream.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
