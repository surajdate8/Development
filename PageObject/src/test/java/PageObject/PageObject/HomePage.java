package PageObject.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	HomePage(WebDriver driver){
		this.driver=driver;
	}
	By search=By.name("srchword");
	By btn=By.xpath("//input[@type='submit' and @xpath='1']");
	
	public WebElement searchBox() {
		return driver.findElement(search);
	}
	public WebElement submit() {
		return driver.findElement(btn);
	}
}
