package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Testing {
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
	@Test
	public void Demo() {
		System.out.println("Hi");
	}
	
	@Test
	public void TC_01() {
		System.out.println("First TC()");
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

}
