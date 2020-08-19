package com.zinrelo.scanarios;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.zinrelo.pages.Member_Page;
import com.zinrelo.utils.ExtentReport;
import com.zinrelo.utils.Prop_Read;

public class EndToEndTest4 extends ExtentReport {
	String dir;
	static WebDriver driver;

	@BeforeSuite
	public void BeforeSuite() throws IOException {
		Prop_Read prop=new Prop_Read();
	}
	@AfterSuite
	public void AfterSuite() {
		driver.close();
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	public void TC_02() throws IOException, InterruptedException {
		test.log(Status.INFO,
				MarkupHelper.createLabel("Verify that the Member option is available for use",ExtentColor.PURPLE));
		Thread.sleep(5000);
		driver.findElement(By.xpath(Index_Page.getMembersButton())).click();
		Boolean add_new_member=driver.findElement(By.xpath(Member_Page.getadd_new_member())).isDisplayed();
		if(add_new_member) {
			test.info("add_new_member option is available for use");
			test.log(Status.PASS, MarkupHelper.createLabel("test status : SUCCESS", ExtentColor.GREEN));
		}
		else
		{
			test.fail("add_new_member option is not available/visible");
			test.log(Status.FAIL, MarkupHelper.createLabel("test status : FAIL", ExtentColor.RED));
			Assert.fail("Test Failed");
		}
	}

	@Test
	public void TC_03() throws IOException, InterruptedException {
		test.log(Status.INFO,
				MarkupHelper.createLabel(
						"Adding new member into active member list",ExtentColor.PURPLE));
		driver.findElement(By.xpath(Member_Page.getadd_new_member())).click();
		Thread.sleep(2000);
		boolean framePresent=driver.findElement(By.xpath(Member_Page.getaddMemberTabframe())).isDisplayed();
		if(framePresent) {
			test.info("add new member frame opened successfully");
			driver.findElement(By.xpath(Member_Page.getFrameEmail())).sendKeys(Prop_Read.getEmail());
			driver.findElement(By.xpath(Member_Page.getFrameFirstName())).sendKeys(Prop_Read.getFirstName());
			driver.findElement(By.xpath(Member_Page.getFrameLastName())).sendKeys(Prop_Read.getLastName());
			driver.findElement(By.xpath(Member_Page.getFrameID())).sendKeys(Prop_Read.getId());
			driver.findElement(By.xpath(Member_Page.getframeAddButton())).click();
			Thread.sleep(2000);
			boolean nestedframePresent=driver.findElement(By.xpath(Member_Page.getnestedFrameId())).isDisplayed();
			if(nestedframePresent) {
				test.info("verification and ok button frame opened successfully");
				driver.findElement(By.xpath(Member_Page.getnestedFrameOk())).click();
				test.log(Status.PASS, MarkupHelper.createLabel("test status : SUCCESS", ExtentColor.GREEN));
			}else {
				test.fail("verification and ok button frame failed");
				test.log(Status.FAIL, MarkupHelper.createLabel("Test status : FAIL", ExtentColor.RED));
				Assert.fail("Test Failed");
			}
		}else {
			test.fail("Frame not available for adding member");
			test.log(Status.FAIL, MarkupHelper.createLabel("Test status : FAIL", ExtentColor.RED));
			Assert.fail("Test Failed");
		}
	}

	@Test
	public void TC_04() throws IOException, InterruptedException {
		test.log(Status.INFO,
				MarkupHelper.createLabel(
						"verify added user is available or not present in member list",ExtentColor.PURPLE));
		driver.findElement(By.xpath(Index_Page.getMembersButton())).click();
		Thread.sleep(2000);

		String[] Name=driver.findElement(By.xpath(Member_Page.getAddedName())).getText().split(" ", 2);
		String EmailId=driver.findElement(By.xpath(Member_Page.getAddedEmail())).getText();
		String firstName=Name[0];
		String lastName=Name[1];
		if(Prop_Read.getFirstName().equals(firstName)&&
				Prop_Read.getLastName().equals(lastName)&&
				Prop_Read.getEmail().equals(EmailId)) {
			test.info("verification for added member is present in list");
			test.log(Status.PASS, MarkupHelper.createLabel("test status : SUCCESS", ExtentColor.GREEN));
		}else {
			test.fail("verification for added member is present failed");
			test.log(Status.FAIL, MarkupHelper.createLabel("Test status : FAIL", ExtentColor.RED));
			Assert.fail("Test Failed");
		}
	}
}