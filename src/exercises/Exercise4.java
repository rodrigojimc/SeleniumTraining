// @author RodrigoJimenezCorrea

package exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.By;

public class Exercise4 {
	
	public static void main (String[] args)  throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Web_drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String submitButton_tagName;
		
		String url = "https://www.toolsqa.com/automation-practice-form/";
		driver.get(url);
		
		driver.findElement(By.partialLinkText("Partial")).click();
		
		System.out.println("");
		
		submitButton_tagName = driver.findElement(By.tagName("button")).toString();
		System.out.println("Submit button:" + submitButton_tagName);
		
		System.out.println("");
	
		driver.findElement(By.linkText("Link Test")).click();
		
		Thread.sleep(5000);
		driver.quit();
		
	}
	
}