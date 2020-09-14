package com.testng;

import org.testng.annotations.Test;

public class Testing3 {
	@Test
	public void TC_01() {
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID);	}
	@Test
	public void TC_02() {
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID);	}
	@Test
	public void TC_03() {
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID);
	}
	@Test
	public void TC_11() {
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseID);
	}

}
