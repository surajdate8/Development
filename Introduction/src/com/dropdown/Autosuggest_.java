package com.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Autosuggest_ {

	public static void main(String[] args) throws InterruptedException {

		String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("ind");

		Thread.sleep(2000);

		List<WebElement> options=driver.findElements(By.cssSelector("div[class='sbl1'] span"));
		for(WebElement option : options) {
			Thread.sleep(3000);
			if(option.getText().equalsIgnoreCase("india map")) {
				Thread.sleep(3000);
				option.click();
				break;
			}
		}

	}

}
