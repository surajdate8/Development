package com.cartItems;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fluent_Wait_83 {

	public static void main(String[] args) {

		String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();

		Wait w=new FluentWait<WebDriver>(driver).
				withTimeout(Duration.ofSeconds(30)).
				pollingEvery(Duration.ofSeconds(3)).
				ignoring(NoSuchElementException.class);

		WebElement e=(WebElement) w.until(new Function<WebDriver,WebElement>() {

			public WebElement apply(WebDriver t) {
				if(t.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
					return t.findElement(By.cssSelector("[id='finish'] h4"));
				else 
					return null;
			}			
		});
		
		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
	}

}
