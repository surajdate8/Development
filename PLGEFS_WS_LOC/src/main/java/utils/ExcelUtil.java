package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	
	public static String dir = System.getProperty("user.dir");
	
	public HashMap<String, LinkedHashMap<String, String>> getTestData(String userStoryName) throws IOException {
		
		File file = new File(dir+"//Config.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		String ws_book = prop.getProperty("WS_workbook");
		
		String FilePath=null;

		if(ws_book.equals("WTC_L4_WS_TestData"))
		{
			 FilePath = dir+"//WTC_L4_WS_TestData.xlsx";
		}else if(ws_book.equals("WS_TestData"))
		{
			FilePath = dir+"//WS_TestData.xlsx";
		}else
		{
			System.out.println("Enter proper workbook in config file.");
		}
		
		
		
		String testCaseId = null;
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
		}
		return Excel;
	}
	
	public void createResultExcel(String fileName)
	{
		//File f = new File("./TestResults/"+fileName+".xlsx");
		File f = new File(dir+"//TestResults//"+fileName+".xlsx"); // rupesh
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
	
	public void writeExcel(String fileName, String testCaseId, String testDesc, String scenarioType, String inputData,
			String wsStatus, String wsStatusCode, String wsResponse, String testResult, String Comments)
	{
		try {
			//String excelFilePath = "./TestResults/"+fileName+".xlsx";
			String excelFilePath = dir+"//TestResults/"+fileName+".xlsx";
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
//			row.setHeightInPoints((15*sheet.getDefaultRowHeightInPoints()));
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
			 
            //FileOutputStream outputStream = new FileOutputStream("./TestResults/"+fileName+".xlsx");
            FileOutputStream outputStream = new FileOutputStream(dir+"//TestResults//"+fileName+".xlsx");
            w.write(outputStream);
            fis.close();
            outputStream.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
