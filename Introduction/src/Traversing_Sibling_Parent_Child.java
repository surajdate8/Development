import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Traversing_Sibling_Parent_Child {

	public static void main(String[] args) throws InterruptedException {

		String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");


		for(int i=1;i<=9;i++) {
			System.out.println(driver.findElement(By.xpath("//table[@class='table-display']/tbody/tr["+i+"]")).getText());
			Thread.sleep(2000);
		}


		System.out.println(driver.findElement(By.xpath("//table[@class='table-display']/tbody/tr/th/following::tr[8]")).getText());



	}

}
