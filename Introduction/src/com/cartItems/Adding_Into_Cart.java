package com.cartItems;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Adding_Into_Cart {

	public static void main(String[] args) {
		String[] itemsNeeded= {"Brocolli"};

		String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		addingIntoCart(driver,itemsNeeded);
		checkoutItems(driver);
		

	}

	private static void checkoutItems(WebDriver driver) {
		driver.findElement(By.cssSelector("img[alt='Cart']")).click(
				);;
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
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
