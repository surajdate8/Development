package com.action.ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ajax_Calls_84 {

	public static void main(String[] args) throws InterruptedException {
		String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Actions a=new Actions(driver);
		
		driver.get("https://www.amazon.in/");
		WebElement move1=driver.findElement(By.id("nav-link-accountList"));
		WebElement move2=driver.findElement(By.id("twotabsearchtextbox"));
		
		a.moveToElement(move1).build().perform();
		a.moveToElement(move2).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		a.moveToElement(move1).contextClick();
		Thread.sleep(2000);
	}

}
