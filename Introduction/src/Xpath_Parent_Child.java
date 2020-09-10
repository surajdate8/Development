import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Parent_Child {
	public static void main(String[] args) {

		String dir=System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bing.com/");
		//driver.findElement(By.xpath("//div[@class='sbx']/div/form/div/input")).sendKeys("test passed");
		//driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div[2]/input")).sendKeys("tested");
		driver.findElement(By.xpath("//div[@class='sbox ']/form/input")).sendKeys("Done");
		
	}
}
