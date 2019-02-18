// @author RodrigoJimenezCorrea

package exercises;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Exercise6 {
	
	public static void main (String[] args)  throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String url = "https://www.toolsqa.com/automation-practice-form/";
		driver.get(url);
		
		
		WebElement continents = driver.findElement(By.id("continents"));
		Select select = new Select(continents);
		select.selectByIndex(1);
		
		
		Thread.sleep(5000);
		select.selectByVisibleText("Africa");
		
		
		List <WebElement> optionsList = select.getOptions();
		String option;
		
		System.out.println();
		
		for (int i=0; i<optionsList.size(); i++) {
			option = optionsList.get(i).getText();
			System.out.println(option);
		}
		
		System.out.println();
		
		Thread.sleep(5000);
		select.selectByIndex(6);
		
		Thread.sleep(5000);
		driver.quit();
		
	}
	
}