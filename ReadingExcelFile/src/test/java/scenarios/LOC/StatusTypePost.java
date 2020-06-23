package scenarios.LOC;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.testng.annotations.*;


import utils.ExcelUtil;
public class StatusTypePost  {

	String scenarioName = getClass().getSimpleName();
	String testCaseDescription, scenarioType, userId,statusType, statusCd,statusName,statusDescription ,token;
	String fileName = this.getClass().getSimpleName();
	ExcelUtil ex = new ExcelUtil();

	@BeforeClass
	public void before() {
		ex.createResultExcel(fileName);
	}

	

	@Test
	public void TC_05() {
		String resFormatted="Ok",Wscode="Wscode",responsestr="responsestr",Wsstatus="Wsstatus";
		
		
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		testDataFields(scenarioName, testCaseID);
				ex.writeExcel(fileName, testCaseID, testCaseDescription, scenarioType, resFormatted, Wsstatus,
						"" + Wscode, responsestr, "Pass", "");

	}


	public void testDataFields(String scenarioName, String testCaseId) {
		HashMap<String, LinkedHashMap<String, String>> inputData1 = null;
		try {
			inputData1 = ex.getTestData(scenarioName);
		} catch (IOException e) {
			e.printStackTrace();
			ex.writeExcel(fileName, testCaseId, "", "", "", "", "", "", "Fail", "Exception: " + e.toString());
		}
		testCaseDescription = inputData1.get(testCaseId).get("TestCaseDescription");
		scenarioType = inputData1.get(testCaseId).get("Scenario Type");
		userId = inputData1.get(testCaseId).get("UserID");
		statusType = inputData1.get(testCaseId).get("statusType");
		statusCd = inputData1.get(testCaseId).get("statusCd");
		statusName = inputData1.get(testCaseId).get("statusName");
		statusDescription = inputData1.get(testCaseId).get("statusDescription");
	
	}


}