import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;

public class facebookxapth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dir=System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		//driver.findElement(By.xpath("//a[@id='mydomainLink']")).click();
		//driver.findElement(By.cssSelector("a[id='mydomainLink']")).click();

		driver.findElement(By.xpath("//a[contains(@id,'mydomainLink')]")).click();

	}

}
