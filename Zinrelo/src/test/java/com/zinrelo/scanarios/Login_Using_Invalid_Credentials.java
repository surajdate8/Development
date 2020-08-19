package com.zinrelo.scanarios;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.zinrelo.pages.Index_Page;
import com.zinrelo.pages.Login_Page;
import com.zinrelo.utils.ExtentReport;
import com.zinrelo.utils.Prop_Read;

public class Login_Using_Invalid_Credentials extends ExtentReport {
	String dir;
	WebDriver driver;

	@BeforeSuite
	public void BeforeSuite() throws IOException {
		@SuppressWarnings("unused")
		Prop_Read prop=new Prop_Read();
		@SuppressWarnings("unused")
		Login_Page login=new Login_Page();
	}

	@BeforeTest
	public void BeforeTest() {
		dir=Prop_Read.getDir();
		System.setProperty("webdriver.chrome.driver", dir+"/src/test/resources/Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(Prop_Read.getUri());	
		
	}

	@BeforeClass
	public void BeforeClass() {

	}

	@BeforeMethod
	protected void startRepo(Method m) throws IOException {
		String testCaseName = m.getName();
		test = extent.createTest(testCaseName);
		driver.findElement(By.xpath(Login_Page.getEmail())).clear();
		driver.findElement(By.xpath(Login_Page.getPassword())).clear();
	}

	@Test
	public void TC_01() {
		
		test.log(Status.INFO,
				MarkupHelper.createLabel(
						"Verify that the error message is displays when invalid Email is passed",
						ExtentColor.PURPLE));
		driver.findElement(By.xpath(Login_Page.getEmail())).sendKeys("InvalidUserId");
		driver.findElement(By.xpath(Login_Page.getPassword())).sendKeys(Prop_Read.getPassWord());
		driver.findElement(By.xpath(Login_Page.getLogin())).click();
		String curretURL=driver.getCurrentUrl();
		String text=driver.findElement(By.xpath(Login_Page.getalertMSG())).getText();
		if(curretURL.equals(Prop_Read.getUri())) {
			test.info("Comparison input URI and Current URI is found correct");
			if(text.equals("Email or password entered is invalid")) {
				test.info("Alert message found correct : "+text);
				test.log(Status.PASS, MarkupHelper.createLabel("test status : SUCCESS", ExtentColor.GREEN));
			}else {
				test.fail("Alert message found incorrect");
				test.info("expected message "+"Email or password entered is invalid");
				test.info("Received message "+text);
				test.log(Status.FAIL, MarkupHelper.createLabel("test status : FAIL", ExtentColor.RED));
				Assert.fail("Test Failed");
			}
		}else {
			test.fail("Comparison input URI and Current URI is found incorrect");
			test.log(Status.FAIL, MarkupHelper.createLabel("test status : FAIL", ExtentColor.RED));
			Assert.fail("Test Failed");
		}
	}


	@Test
	public void TC_02() throws IOException {
		test.log(Status.INFO,
				MarkupHelper.createLabel(
						"Verify that the error message is displays when invalid Password is passed",
						ExtentColor.PURPLE));
		driver.findElement(By.xpath(Login_Page.getEmail())).sendKeys(Prop_Read.getUserId());
		driver.findElement(By.xpath(Login_Page.getPassword())).sendKeys("InvalidPassword");
		driver.findElement(By.xpath(Login_Page.getLogin())).click();
		String curretURL=driver.getCurrentUrl();
		String text=driver.findElement(By.xpath(Login_Page.getalertMSG())).getText();
		if(curretURL.equals(Prop_Read.getUri())) {
			test.info("Comparison input URI and Current URI is found correct");
			if(text.equals("Email or password entered is invalid")) {
				test.info("Alert message found correct : "+text);
				test.log(Status.PASS, MarkupHelper.createLabel("test status : SUCCESS", ExtentColor.GREEN));
			}else {
				test.fail("Alert message found incorrect");
				test.info("expected message "+"Email or password entered is invalid");
				test.info("Received message "+text);
				test.log(Status.FAIL, MarkupHelper.createLabel("test status : FAIL", ExtentColor.RED));
				Assert.fail("Test Failed");
			}
		}else {
			test.fail("Comparison input URI and Current URI is found incorrect");
			test.log(Status.FAIL, MarkupHelper.createLabel("test status : FAIL", ExtentColor.RED));
			Assert.fail("Test Failed");
		}

	}
}
