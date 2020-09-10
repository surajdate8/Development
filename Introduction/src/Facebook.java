import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String dir=System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
//		driver.findElement(By.id("username")).sendKeys("Entering text");
//		driver.findElement(By.name("pw")).sendKeys("123456");
//		driver.findElement(By.id("Login")).click();
//		System.out.println(driver.findElement(By.xpath("//*[@id=\"error\"]")).getText());
//		
		driver.findElement(By.xpath("//a[@id='mydomainLink']")).click();
	
		
		//driver.close();

	}

}
