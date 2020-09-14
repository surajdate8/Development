package PageObject.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginApplication {
	WebDriver driver;
	String dir=System.getProperty("user.dir");
	@Test
	public void Login() {
		System.setProperty("webdriver.chrome.driver",dir+ "/Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		ReddiffLoginPg rd=new ReddiffLoginPg(driver);
		HomePage pg=new HomePage(driver);
		
		rd.emailId().sendKeys("surajdate");
		rd.passWd().sendKeys("12345");
		rd.Login().click();
		
	}

}
