package com.src.excels;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.gson.JsonObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class Testing_Class {

	public static String dir = System.getProperty("user.dir");

	String testCaseDescription, scenarioType, userId,statusType, statusCd,statusName,statusDescription ,token;
	String resFormatted, Wsstatus, Wscode, responsestr;
	String scenarioName = getClass().getSimpleName();
	String fileName = this.getClass().getSimpleName();
	ExcelUtil ex = new ExcelUtil();
	String testCaseID;


	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public static ExtentTest test;






	@Test
	public void extent_check() {
		htmlReporter=new ExtentHtmlReporter(dir+"/Web_Extend_Reports/"+scenarioName+".html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		test=extent.createTest("First");

		test.info("Check");


	}



	@Test(priority = 1)
	public void create_excel() {
		ex.createResultExcel(fileName);
		System.out.println("Excel Created");

	}

	@Test(priority = 2)
	public void RW_Excel() {

		testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		testDataFields(scenarioName, testCaseID);

	}

	@Test(priority = 3)
	public void TC_01() {

		htmlReporter=new ExtentHtmlReporter(dir+"/Web_Extend_Reports/"+scenarioName+".html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		test=extent.createTest("First");


		/*
		 * // Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		 * 
		 * int statusCode=response.getStatusCode(); if(statusCode==200) { String
		 * resFormatted=FormatJson.jsonFormat(response.asString());
		 * System.out.println(resFormatted.toString());
		 * 
		 * test.info(resFormatted); ex.writeExcel(fileName, testCaseID,
		 * testCaseDescription, scenarioType, resFormatted, Wsstatus, "" + Wscode,
		 * resFormatted, "Pass", ""); Assert.assertEquals(statusCode, 200); }else {
		 * test.info("Failed");
		 * 
		 * }
		 */
		
		JSONObject request=new JSONObject();
		
		request.put("firstName","S");
		request.put("lastName","S");
		request.put("subjectId","3");
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
		
		

		extent.flush();
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
