package com.zinrelo.scanarios;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
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

public class Launching_To_Index_Page_Test2 extends ExtentReport {
	String dir,testCaseID;
	static WebDriver driver;

	@BeforeSuite
	public void BeforeSuite() throws IOException {
		@SuppressWarnings("unused")
		Prop_Read prop=new Prop_Read();
	}
	
	@AfterSuite
	public void AfterSuite() {
		driver.quit();
	}

	@BeforeTest
	public void BeforeTest() {
		dir=Prop_Read.getDir();
		System.setProperty("webdriver.chrome.driver", dir+"/src/test/resources/Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Prop_Read.getUri());	
	}

	@BeforeMethod
	protected void startRepo(Method m) throws IOException {
		
		String testCaseName = m.getName();
		test = extent.createTest(testCaseName);
	}

	@Test
	public static void TC_01() throws IOException, InterruptedException {
		test.log(Status.INFO,
				MarkupHelper.createLabel(
						"Verify that the user successfully logged in when provide valid credentials",ExtentColor.PURPLE));
		driver.findElement(By.xpath(Login_Page.getEmail())).sendKeys(Prop_Read.getUserId());
		driver.findElement(By.xpath(Login_Page.getPassword())).sendKeys(Prop_Read.getPassWord());
		driver.findElement(By.xpath(Login_Page.getLogin())).click();
		Thread.sleep(4000);
		String curretURL=driver.getCurrentUrl();
		if(curretURL.equals(Prop_Read.getindexPageUrl())) {
			test.info("Comparison index page URI and Current URI is found correct");
			String welcomeText=driver.findElement(By.xpath(Index_Page.getZinreloText())).getText();
			if(welcomeText.equals("Zinrelo 1")) {
				test.info("welcomeText message found correct : "+welcomeText);
				test.log(Status.PASS, MarkupHelper.createLabel("test status : SUCCESS", ExtentColor.GREEN));
			}else {
				test.fail("welcomeText message found incorrect");
				test.info("expected message "+"WelcomeBack!");
				test.info("Received message "+welcomeText);
				test.log(Status.FAIL, MarkupHelper.createLabel("test status : FAIL", ExtentColor.RED));
				Assert.fail("Test Failed");
			}
		}else {
			test.fail("Comparison index page URI and Current URI is found incorrect");
			test.log(Status.FAIL, MarkupHelper.createLabel("test status : FAIL", ExtentColor.RED));
			Assert.fail("Test Failed");
		}
	}

	@Test
	public void TC_02() throws IOException {
		testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test.log(Status.INFO,
				MarkupHelper.createLabel(
						"Verify that the Member option is available for use",
						ExtentColor.PURPLE));
		Boolean MemberVerify=driver.findElement(By.xpath(Index_Page.getMembersButton())).isDisplayed();
		if(MemberVerify) {
			test.info("Member option is available for use");
			test.log(Status.PASS, MarkupHelper.createLabel("test status : SUCCESS", ExtentColor.GREEN));
		}
		else
		{
			test.fail("Member option is not available/visible");
			test.log(Status.FAIL, MarkupHelper.createLabel("test status : FAIL", ExtentColor.RED));
			Assert.fail("Test Failed");
		}
	}

}
