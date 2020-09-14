import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Objects_With_Xpath_45 {
	public static void main(String[] args) {
		
		String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElement(By.xpath("//*[text()='Latest News']")).getText());
	}

}
