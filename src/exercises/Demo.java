package exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {
	
	public static void main (String[] args)  throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com");
		
		Thread.sleep(5000);
		driver.quit();
		
	}
	
}
