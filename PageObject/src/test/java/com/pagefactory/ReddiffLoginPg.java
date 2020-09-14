package com.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReddiffLoginPg {
	
	WebDriver driver;
	ReddiffLoginPg(WebDriver driver){
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}


	@FindBy(name = "login")
	WebElement name;
	
	@FindBy(name = "passwd")
	WebElement password;
	
	@FindBy(name = "proceed")
	WebElement proceed;
	
	

}
