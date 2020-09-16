package pageObject;

import org.openqa.selenium.*;

public class LandingPage {

	public LandingPage(WebDriver driver){
		this.driver=driver;
	}

	public WebDriver driver;
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.xpath("//div[@class='text-center']/h2");
	By naviBar=By.cssSelector("[class='nav navbar-nav navbar-right']");

	public WebElement getNaviBar() {
		return driver.findElement(naviBar);
	}
	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}


}
