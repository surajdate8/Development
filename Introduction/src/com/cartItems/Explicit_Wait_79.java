package com.cartItems;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit_Wait_79 {

	public static void main(String[] args) {
		String[] itemsNeeded= {"Brocolli"};

		String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver, 5);

		addingIntoCart(driver,itemsNeeded);
		checkoutItems(driver,w);


	}

	private static void checkoutItems(WebDriver driver,WebDriverWait w) {
			
		driver.findElement(By.cssSelector("img[alt='Cart']")).click(
				);
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[class='promoCode']")));
		//w.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='resultsContainer']/section/article[1]")));

		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='promoInfo']")));

		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
	}

	private static void addingIntoCart(WebDriver driver,String[] itemsNeeded) {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		int j=itemsNeeded.length;
		List<WebElement> products=driver.findElements(By.xpath("//div//h4[@class='product-name']"));
		for(int i=0;i<products.size();i++) {
			List itemsNeededList=Arrays.asList(itemsNeeded);

			String[] name=products.get(i).getText().split("-");
			String formatttedName=name[0].trim();

			if(itemsNeededList.contains(formatttedName)) 
			{
				j--;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==0) {
					break;
				}
			}
		}

	}

}
