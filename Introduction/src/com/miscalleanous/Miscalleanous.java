package com.miscalleanous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscalleanous {

	public static void main(String[] args) {
		String dir=System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed("abc");
		//driver.manage().addCookie("abc");
		
		driver.get("https://google.com");
	}

}
