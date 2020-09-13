package com.report;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	String dir=System.getProperty("user.dir");
	ExtentSparkReporter reporter;
	ExtentReports extent;
	@BeforeTest
	public void config() {
		reporter=new ExtentSparkReporter(dir+"/Reports");
		reporter.config().setReportName("WebAutomation Result");
		reporter.config().setDocumentTitle("Web Report");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA :", " Suraj Date");
		
	}
	
	
	@Test
	public void TC_01() {
		String testCaseId=this.getClass().getSimpleName();
		ExtentTest test=extent.createTest(testCaseId);
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacadmy.com");
		System.out.println(driver.getTitle());
		test.fail("failed");
	}

	
	@AfterTest
	public void afterTest() {
		extent.flush();
	}
}
