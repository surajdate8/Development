package com.facebook.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver.*;

public class LoginPage {
	String dir;
	WebDriver driver;
	WebElement day,month,year;
	Select d,m,y;

	@BeforeClass
	public void beforeClass() {
		dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				dir+"/src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();


	}

	@Test
	public void testDOB() {
		System.out.println("Test Stated");

		driver.get("https://www.facebook.com/");

		day=driver.findElement(By.id("day"));
		d=new Select(day);
		d.selectByIndex(22);

		month=driver.findElement(By.id("month"));
		m=new Select(month);
		m.selectByIndex(8);

		year=driver.findElement(By.id("year"));
		y=new Select(year);
		y.selectByValue("1996");
	}

	@AfterClass
	public void afterClass()throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
