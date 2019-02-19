// @author RodrigoJimenezCorrea

package exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.By;

public class Exercise3 {
	
	public static void main (String[] args)  throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Web_drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String url = "https://www.toolsqa.com/automation-practice-form/";
		driver.get(url);
		
		driver.findElement(By.name("firstname")).sendKeys("Rodrigo");
		driver.findElement(By.name("lastname")).sendKeys("Jimenez");
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("submit")).click();
		
		Thread.sleep(5000);
		driver.quit();
		
	}
	
}