// @author RodrigoJimenezCorrea

package exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise1 {
	
	public static void main (String[] args)  throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//String url = "https://store.demoqa.com";
		String url = "https://www.toolsqa.com/";
		String currentUrl;
		
		String sourceCode;
		String pageTitle;
		
		driver.get(url);
		pageTitle = driver.getTitle();
		
		System.out.println("");
		
		System.out.println("Page title: " + pageTitle);
		System.out.println("Page title lenght: " + pageTitle.length());
		
		currentUrl = driver.getCurrentUrl();
		
		//if(currentUrl.compareTo(url) == 0){
		if(currentUrl.contains(url) == true) { System.out.println("Correct page opened!"); } 
		else { System.out.println("Incorrect page opened!"); }
		
		sourceCode = driver.getPageSource();
		System.out.println("Source code length: " + sourceCode.length());
		
		System.out.println("");
		
		driver.quit();
		
	}
	
}
