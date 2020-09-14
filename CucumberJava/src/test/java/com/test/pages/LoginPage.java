package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	protected WebDriver driver;

	private By txt_username = By.name("login");
	private By txt_password = By.name("password");
	private By btn_login = By.name("commit");


	public LoginPage(WebDriver driver) {
		this.driver=driver;
//		if(!driver.getTitle().equals("Sign in to GitHub  GitHub")) {
//			throw new IllegalStateException("This is not login page, Current URI is : -"
//					+driver.getCurrentUrl());
//
//		}
	}

	public void enterUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(btn_login).click();
	}


	//	public void loginValidUser(String username,String password) {
	//		driver.findElement(txt_username).sendKeys(username);
	//		driver.findElement(txt_password).sendKeys(password);
	//		driver.findElement(btn_login).click();
	//	}

}
