package com.create.account;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadGoogleMessages {
	WebDriver driver=null;
	String path=System.getProperty("user.dir");

	@Test
	public void Test()
	{
		System.out.println("In Step - browser is open");
		System.out.println("Project path - "+path);

		System.setProperty("webdriver.chrome.driver", path+"/Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();



		driver.navigate().to("https://messages.google.com/web/conversations/466");
		/*
		 * driver.findElement(By.name("firstName")).sendKeys("Suraj");
		 * driver.findElement(By.name("lastName")).sendKeys("Date");
		 * driver.findElement(By.name("Username")).sendKeys("surajdate321654");
		 * driver.findElement(By.name("Passwd")).sendKeys("Date@123$");
		 * driver.findElement(By.name("ConfirmPasswd")).sendKeys("Date@123$");
		 * driver.findElement(By.xpath("//span[contains(text(), \"Next\")]")).click();
		 * 
		 * driver.findElement(By.id("phoneNumberId")).sendKeys("9657726764");
		 * 
		 * driver.findElement(By.xpath("//span[contains(text(), \"Next\")]")).click();
		 */
		/*
		 * driver.close(); driver.quit();
		 */
	}


}
