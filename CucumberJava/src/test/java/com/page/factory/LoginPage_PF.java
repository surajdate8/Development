package com.page.factory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage_PF {
	WebDriver driver;
	
	@FindBy(id = "name")
	@CacheLookup
	WebElement txt_usrname;
	
	@FindBy(id = "password")
	@CacheLookup
	WebElement txt_password;
	
	@FindBy(id = "login")
	@CacheLookup
	WebElement btn_login;
	
	@FindBy(partialLinkText = "Suraj")
	List<WebElement> mylinks;
	
	public LoginPage_PF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver, 30);
		
	}
	
	public void enterUsername(String username){
		txt_usrname.sendKeys(username);
	}

	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickOnLogin()
	{
		btn_login.click();
	}
}
