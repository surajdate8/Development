package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {
	static String browserName;
	public  WebDriver driver;
	public Properties prop;
	String dir=System.getProperty("user.dir");
	public WebDriver initializeDriver() throws IOException
	{

		prop= new Properties();
		FileInputStream fis=new FileInputStream(dir+"/src/main/java/resources/data.properties");

		prop.load(fis);
		//String browserName=prop.getProperty("browser");
		browserName=System.getProperty("browser");
		System.out.println(browserName);

		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",dir+ "/Driver/chromedriver.exe");
			driver= new ChromeDriver();

		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",dir+ "/Driver/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver",dir+ "/Driver/IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;


	}


	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}

}
