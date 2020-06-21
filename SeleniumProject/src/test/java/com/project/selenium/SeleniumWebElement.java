package com.project.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumWebElement {

	String dir;
	WebDriver driver;

	@Test
	public void TestTC_01()throws Exception {

		dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				dir+"/src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Poco F1");
		driver.findElement(By.className("nav-input")).click();
		driver.findElement(By.linkText("ACM")).click();
		
		driver.navigate().to("https://google.com");
		Thread.sleep(2000);
		driver.navigate().back();
		
		driver.quit();

	}

}
