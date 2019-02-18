// @author RodrigoJimenezCorrea

package exercises;

import java.util.ArrayList;
//import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercise10 {

	public static void main (String[] args)  throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url = "https://www.toolsqa.com/automation-practice-switch-windows/";
		driver.get(url);
		
		String window = driver.getWindowHandle(); 
		
		System.out.println();
		System.out.println(window);
		System.out.println();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]/button")).click();
		
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		//Set <String> allWindows = driver.getWindowHandles();
		ArrayList<String> allWindows = new ArrayList<String> (driver.getWindowHandles());
		
		for (String s: allWindows) {
			
			System.out.println(s);
			//driver.switchTo().window(s);
			
		}
		System.out.println();
		
		//driver.switchTo().window((String) allWindows.toArray()[1]);
		driver.switchTo().window(allWindows.get(1));
		
		Thread.sleep(2000);
		
		driver.close();
		
		Thread.sleep(5000);
		driver.quit();
	}
	
}
