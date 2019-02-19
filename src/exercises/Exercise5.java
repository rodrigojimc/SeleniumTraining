// @author RodrigoJimenezCorrea

package exercises;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;

public class Exercise5 {
	
	public static void main (String[] args)  throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Web_drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String url = "https://www.toolsqa.com/automation-practice-form/";
		driver.get(url);
		
//		Challenge 1
		
//		WebElement female = driver.findElement(By.id("sex-1"));
//		boolean femaleIsSelected = female.isSelected();
//		if (femaleIsSelected == false) {female.click(); }
		
//		Male was not selected by default
		driver.findElement(By.id("sex-0")).click();
		
		List<WebElement> sex = driver.findElements(By.name("sex"));
		for (int i=0; i<sex.size() ; i++ ) {
			if (sex.get(i).isSelected() == false) {
				sex.get(i).click();
			}
		}
		
//		Challenge 2
		
		List<WebElement> exp = driver.findElements(By.name("exp"));
		for (int i=0; i<exp.size() ; i++ ) {
			if (exp.get(i).getAttribute("id").equals("exp-2")) {
				exp.get(i).click();
			}
		}
		
//		Challenge 3
		
		List<WebElement> profession = driver.findElements(By.name("profession"));
		for (int i=0; i<profession.size() ; i++ ) {
			if (profession.get(i).getAttribute("value").equals("Automation Tester")) {
				profession.get(i).click();
			}
		}
		
//		Challenge 4
		
//		WebElement tool = driver.findElement(By.cssSelector("input[value='QA']"));
//		tool.click();
		
		driver.findElement(By.cssSelector("input[value='Selenium IDE']")).click();
		
		Thread.sleep(5000);
		driver.quit();
		
	}
	
}
