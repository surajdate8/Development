package com.testng;

import org.testng.Assert;
import org.testng.annotations.*;

public class Testing2 {
	String name=this.getClass().getSimpleName();
	
	@BeforeSuite
	public void BeforeSuite() {
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID+name);
	}
	
	@AfterSuite
	public void AfterSuite() {
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID+name);
	}

	@BeforeTest
	public void BeforeTest() 
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID);	
	}
	@AfterTest
	public void AfterTest() 
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID);	
	}
	@Test(dependsOnMethods = {"TC_04"}
			,enabled = true
			,timeOut = 4000)
	@Parameters({"url","url/key"})
	public void TC_01(String url,String key) 
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(url.toUpperCase()+"\n"+key+"\n"+testCaseID);	
	}
	@Test(groups = {"smoke","sanity"})
	public void TC_02() 
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID);	
	}
	@Test(groups = {"sanity"})
	public void TC_03() 
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID);	
		//Assert.assertTrue(false);
	}
	@Test(groups = {"sanity"},dataProvider = "getData")
	public void TC_04(String username,String password) 
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID);	
		System.out.println(username+"\t"+password);
		
	}

	@BeforeMethod
	public void BeforeMethod() {
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID+name);
	}
	
	@AfterMethod
	public void AfterMethod() {
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID+name);
	}
	@BeforeClass
	public void BeforeClass() {
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID+name);
	}
	
	@AfterClass
	public void AfterClass() {
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID+name);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[3][2];
		data[0][0]= "suraj";
		data[0][1]= "suraj123";
		
		data[1][0]= "dhiraj";
		data[1][1]= "dhiraj123";

		data[2][0]= "gajanan";
		data[2][1]= "gajanan123";
		
		return data;
		
	}
	
}
