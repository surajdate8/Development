package FrameWorkBuild.FrameWorkBuild;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	public WebDriver driver;
	@BeforeTest
	public void initilize() throws IOException {
		driver=initializeDriver();
		driver.get(url);

	}
	@Test
	public void basePageNavigation() throws IOException {


		LandingPage l=new LandingPage(driver);
		String title=l.getTitle().getText();
		Assert.assertEquals(title,"FEATURED COURSES");

		Boolean val=l.getNaviBar().isDisplayed();
		Assert.assertEquals(val, false);
	}


	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
