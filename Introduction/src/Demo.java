import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dir=System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getPageSource());
		
		driver.navigate().to("http://yahoo.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.close();
		driver.quit();

	}

}
