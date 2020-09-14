package com.table_excercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table_Soring {

	public static void main(String[] args) {
		String dir=System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		
	}

}
