package com.step.definations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {

//	WebDriver driver=null;
//	String path=System.getProperty("user.dir");
//
//	@Given("browser is open")
//	public void browser_is_open() {
//
//		System.out.println("In Step - browser is open");
//		System.out.println("Project path - "+path);
//
//		System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/Feature/Driver/chromedriver.exe");
//		driver=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//	}
//
//	@And("user is on google search page")
//	public void user_is_on_google_search_page() {
//
//		System.out.println("In Step - user is on google search page");
//
//		driver.navigate().to("https://google.com");
//
//	}
//
//
//	@When("user enter a text in search box")
//	public void user_enter_a_text_in_search_box() {
//
//		System.out.println("In Step - user enter a text in search box ");
//		driver.findElement(By.name("q")).sendKeys("Automation step by step");
//	}
//
//	@And("hits enter")
//	public void hits_enter() {
//
//		System.out.println("In Step - his enter");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//	}
//
//	@Then("user navigated to search results")
//	public void user_navigated_to_search_results() {
//
//		System.out.println("In Step - user navigated to serach results");
//		driver.getPageSource().contains("Online Courses");
//		driver.close();
//		driver.quit();
//	}



}
