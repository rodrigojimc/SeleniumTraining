// @author RodrigoJimenezCorrea

package exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class Exercise11 {

	public static void main (String[] args)  throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url = "https://www.toolsqa.com/automation-practice-switch-windows/";
		driver.get(url);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"alert\"]")).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println();
		System.out.println(alert.getText());
		System.out.println();
		
		alert.accept();
		
		Thread.sleep(5000);
		driver.quit();
	}
	
}