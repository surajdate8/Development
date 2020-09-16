package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class Base {
	String dir=System.getProperty("user.dir");
	public WebDriver driver;
	Properties prop;
	FileInputStream file;
	public String url;

	public WebDriver initializeDriver() throws IOException {
		prop=new Properties();
		file=new FileInputStream(dir+"/src/main/java/resources/data.properties");
		prop.load(file);
		String browser=prop.getProperty("browser");
		url=prop.getProperty("url");

		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");	
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", dir+"/Driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", dir+"/Driver/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
