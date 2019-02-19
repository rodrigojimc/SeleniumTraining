// @author RodrigoJimenezCorrea

package exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;

public class Exercise9 {

	public static void main (String[] args)  throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Web_drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String url = "https://www.toolsqa.com/automation-practice-table/";
		driver.get(url);
		
		String sCol;
		String text;
		WebElement cell;
		
		text = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[2]")).getText();
		
		System.out.println();
		System.out.println(text);
		System.out.println();
		
		cell = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[2]/th"));
		text = cell.getText();
		System.out.println(text);
	
		for (int i=1; i<6; i++) {
			
			sCol = Integer.toString(i);
			cell = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[2]/td["+sCol+"]"));
			text = cell.getText();
			System.out.println(text);
			
		}
			
		System.out.println();

		driver.quit();
	}
	
}
