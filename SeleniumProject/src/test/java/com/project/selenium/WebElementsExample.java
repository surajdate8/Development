package com.project.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebElementsExample {
	String dir;
	WebDriver driver;	

	@BeforeClass
	public void beforeClass()throws InterruptedException{
		dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				dir+"/src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		//driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}
	
	@Test
	public void TC_ID()throws InterruptedException {
		driver.get("https://accounts.google.com/signup/v2");
		driver.findElement(By.id("firstName")).sendKeys("Suraj");
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void TC_Name()throws InterruptedException{
		driver.get("https://accounts.google.com/signup/v2");
		driver.findElement(By.name("firstName")).sendKeys("Suraj");
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void TC_Class() {
		driver.findElement(By.id(""));
	}
	
	@Test
	public void TC_LinkText()throws InterruptedException {
		driver.get("https://login.yahoo.com/account/challenge/phone-verify?");
		driver.findElement(By.linkText("Help")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void TC_CSS_Selector()throws InterruptedException{
		driver.get("https://accounts.google.com/signup/v2");
		driver.findElement(By.cssSelector("#firstName")).sendKeys("Suraj");
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void TC_Partial_Link_Text()throws InterruptedException{
		driver.get("https://login.yahoo.com/account/challenge/phone-verify?");
		driver.findElement(By.partialLinkText("Hel")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void TC_Xpath()throws InterruptedException {
		driver.get("https://accounts.google.com/signup/v2");
		driver.findElement(By.xpath("//div[@jsname=\"bCkDte\"]")).click();
		Thread.sleep(2000);
		driver.close();
	}
}
