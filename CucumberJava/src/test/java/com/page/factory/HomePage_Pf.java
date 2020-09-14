package com.page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Pf {
	@FindBy(id = "logout")
	WebElement btn_logout;
	
	WebDriver driver;
	public HomePage_Pf() {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void checkLogout() {
		btn_logout.isDisplayed();
	}

}
