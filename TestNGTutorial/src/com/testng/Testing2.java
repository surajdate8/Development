package com.testng;

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
	@Test
	public void TC_01() 
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID);	
	}
	@Test
	public void TC_02() 
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID);	
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
	
}
