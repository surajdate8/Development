package com.step.definations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.page.factory.HomePage_Pf;
import com.page.factory.LoginPage_PF;

import io.cucumber.java.en.*;

public class LoginDemoSteps_PF {

	LoginPage_PF login;
	HomePage_Pf home;
	
	WebDriver driver=null;
	String path=System.getProperty("user.dir");

	@Given("browser is open")
	public void browser_is_open() {

		System.out.println("Inside PF-Demo");
		System.out.println("In Step - browser is open");
		System.out.println("Project path - "+path);

		System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/Feature/Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		driver.navigate().to("https://example.testproject.io/web/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) {
		login = new LoginPage_PF(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();
	}

	@Then("usr is navigated to the home page")
	public void usr_is_navigated_to_the_home_page() {
		home=new HomePage_Pf();
		home.checkLogout();
		driver.close();
		driver.quit();
	}


}
