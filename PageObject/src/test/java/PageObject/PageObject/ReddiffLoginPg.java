package PageObject.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReddiffLoginPg {
	
	WebDriver driver;
	ReddiffLoginPg(WebDriver driver){
		this.driver=driver;
	}
	By username=By.name("login");
	By password=By.name("passwd");
	By go=By.name("proceed");
	By home=By.linkText("rediff");
	
	public WebElement emailId() {
		return driver.findElement(username);
	}
	public WebElement passWd() {
		return driver.findElement(password);
	}
	
	public WebElement Login() {
		return driver.findElement(go);
	}
	
	public WebElement homePageLink() {
		return driver.findElement(home);
	}

}
