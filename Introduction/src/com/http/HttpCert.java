package com.http;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HttpCert {

	public static void main(String[] args) {
		String dir=System.getProperty("user.dir");
		
		DesiredCapabilities ch=DesiredCapabilities.chrome();
		//ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions c=new ChromeOptions();
		c.merge(ch);
		
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver(c);
		
		
	}

}
