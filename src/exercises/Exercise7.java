// @author RodrigoJimenezCorrea

package exercises;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Exercise7 {
	
	public static void main (String[] args)  throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Web_drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String url = "https://www.toolsqa.com/automation-practice-form/";
		driver.get(url);
		
		WebElement seleniumCommands = driver.findElement(By.name("selenium_commands"));
		Select select = new Select(seleniumCommands);
		
		select.selectByIndex(0);
		Thread.sleep(2000);
		select.deselectByIndex(0);
		Thread.sleep(2000);
		
		select.selectByVisibleText("Navigation Commands");
		Thread.sleep(2000);
		select.deselectByVisibleText("Navigation Commands");
		Thread.sleep(2000);
		
		List <WebElement> optionsList = select.getOptions();
		String option;
		
		System.out.println();
		
		for (int i=0; i<optionsList.size(); i++) {
			option = optionsList.get(i).getText();
			select.selectByIndex(i);
			Thread.sleep(500);
			System.out.println(option);
		}
		
		for (int i=0; i<optionsList.size(); i++) {
			select.deselectByIndex(i);
			Thread.sleep(500);
		}
		
		System.out.println();
		
		Thread.sleep(5000);
		driver.quit();
		
	}
	
}