package com.cartItems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_80 {

	public static void main(String[] args) {

		String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver, 5);
		
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Click to load get data via Ajax!']")));
		
		driver.findElement(By.xpath("//a[text()='Click to load get data via Ajax!']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.id("results")));
		
		System.out.println(driver.findElement(By.cssSelector("div[id='results']")).getText());
	}

}
