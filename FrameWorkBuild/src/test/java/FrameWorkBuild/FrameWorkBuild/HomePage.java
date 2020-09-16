package FrameWorkBuild.FrameWorkBuild;
import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;
public class HomePage extends Base {
	public WebDriver driver;

	@BeforeTest
	public void initilize() throws IOException {
		driver=initializeDriver();
		driver.get(url);

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String email,String password,String text) throws IOException {
		LandingPage l=new LandingPage(driver);
		LoginPage log=new LoginPage(driver);

		l.getLogin().click();
		log.getEmail().sendKeys(email);
		log.getPass().sendKeys(password);
		log.getSubmit().click();
	}


	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[2][3];
		data[0][0]="nonrestrictred@gmail.com";
		data[0][1]="123$";
		data[0][2]="Restricted User";

		data[1][0]="restrictred@gmail.com";
		data[1][1]="123$";
		data[1][2]="nonRestricted User";

		return data;
	}


	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
