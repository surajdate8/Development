package stepDefination;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoginFreeCRM {
	WebDriver driver;
	String dir=System.getProperty("user.dir");
	@Given("user in on login page")
	public void user_in_on_login_page() {
		System.out.println("Started");
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
	//	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://ui.freecrm.com/");
	}

	@When("user will enter user id and password")
	public void user_will_enter_user_id_and_password() {
		driver.findElement(By.name("email")).sendKeys("surajdate8@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Date@0895");
	}

	@Then("user hit login button")
	public void user_hit_login_button() {
		driver.findElement(By.xpath("//div[text()='Login']")).click();
	}

	@Then("user will landed to HOME page")
	public void user_will_landed_to_HOME_page() {
		String title=driver.getTitle();
		Assert.assertEquals("Cogmento CRM", title);
		System.out.println(title);
		System.out.println("completed");
		driver.quit();
	}

}
