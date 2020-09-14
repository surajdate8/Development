package com.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test_60 {
	public static void main(String[] args) throws InterruptedException {
		String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//input[@value='option1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='option1']")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
		
		System.out.println(driver.findElement(By.xpath("//label//input[@type='checkbox']")).getSize());
		System.out.println(driver.findElement(By.xpath("//label//input[@type='checkbox']")).getSize());

	}

}
