package com.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assert_59 {

	public static void main(String[] args) {
		String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.spicejet.com/");
		
		Assert.assertFalse((driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).isSelected()));
		//Assert.assertTrue((driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).isSelected()));
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).isSelected());
		
	}

}
