// @author RodrigoJimenezCorrea

package exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.By;

public class Exercise8 {

	public static void main (String[] args)  throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Web_drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String url = "https://www.toolsqa.com/automation-practice-table/";
		driver.get(url);
		
		String text;
		
		text = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[2]")).getText();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[6]/a")).click();
		
		System.out.println();
		System.out.println(text);
		System.out.println();
		
		Thread.sleep(5000);
		driver.quit();
	}
	
}

