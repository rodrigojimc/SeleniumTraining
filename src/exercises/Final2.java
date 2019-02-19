// @author RodrigoJimenezCorrea
// Trying different ways

package exercises;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Final2 {

	static Random random = new Random();
	
	public static void clickRadioButtonByValue(String value, List <WebElement> group) {
		
		WebElement radio;
		
		for(int i=0; i<group.size(); i++) {
			radio = group.get(i);
			if(radio.getAttribute("value").equals(value)) {
				radio.click();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Web_drivers\\geckodriver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Web_drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String user = "mercury";
		String pass = "mercury";
		
		String url = "http://newtours.demoaut.com";
		driver.get(url);
		
		//MAIN PAGE
		
		//Sing-On
		
		WebElement singOnOff =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a"));
		String signed = singOnOff.getText();
		
		if (signed.compareTo("SING-OFF")==0) {singOnOff.click();} //if already singed
		singOnOff.click();
		
		//SING ON PAGE	http://newtours.demoaut.com/mercurysignon.php
		
		WebElement userName = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td[2]/input"));
		userName.sendKeys(user);
		
		WebElement password = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input"));
		password.sendKeys(pass);
		
		//Submit
		
		Thread.sleep(3000);
		
		WebElement submitSing = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/input"));
		submitSing.click();
		
		//FLIGHT FINDER PAGE 	//http://newtours.demoaut.com/mercuryreservation.php
		
		//Flight Details
		
		List <WebElement> tripTrype = driver.findElements(By.name("tripType"));
		clickRadioButtonByValue("roundtrip", tripTrype);
		
		String numberOfPassengers = Integer.toString(3);
		WebElement passengers = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/b/select"));
		Select select_passengers = new Select(passengers);
		select_passengers.selectByVisibleText(numberOfPassengers);
		
		WebElement fromPort = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select"));
		Select select_fromPort = new Select(fromPort);
		select_fromPort.selectByVisibleText("Acapulco");
		
		WebElement fromMonth = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td[2]/select[1]"));
		Select select_fromMonth = new Select(fromMonth);
		select_fromMonth.selectByVisibleText("June");
		
		WebElement fromDay = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td[2]/select[2]"));
		Select select_fromDay= new Select(fromDay);
		select_fromDay.selectByVisibleText("27");
		
		WebElement toPort = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td[2]/select"));
		Select select_toPort = new Select(toPort);
		select_toPort.selectByVisibleText("London");
		
		WebElement toMonth = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/select[1]"));
		Select select_toMonth = new Select(toMonth);
		select_toMonth.selectByVisibleText("July");
		
		WebElement toDay = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/select[2]"));
		Select select_toDay = new Select(toDay);
		select_toDay.selectByVisibleText("1");
		
		//Preferences
		
		List <WebElement> servClass = driver.findElements(By.name("servClass"));
		clickRadioButtonByValue("Busniess", servClass);
		
		WebElement airline = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/select"));
		Select select_airline = new Select(airline);
		select_airline.selectByVisibleText("Blue Skies Airlines");
		
		//Continue
		
		Thread.sleep(3000);
		
		WebElement continue1 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input"));
		continue1.click();
		
		//SELECT FLIGHT PAGE 	http://newtours.demoaut.com/mercuryreservation2.php
				
		//Depart
		
		List <WebElement> outFlight = driver.findElements(By.name("outFlight"));
		outFlight.get(1).click();
		
		//Return
		
		List <WebElement> inFlight = driver.findElements(By.name("inFlight"));
		inFlight.get(2).click();
		
		//Continue
		
		Thread.sleep(3000);
		
		WebElement continue2 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input"));
		continue2.click();
		
		//BOOK A FLIGHT PAGE 	http://newtours.demoaut.com/mercurypurchase.php
		
		List <WebElement> passFirst = driver.findElements(By.cssSelector("input[name^='passFirst']"));
		List <WebElement> passLast = driver.findElements(By.cssSelector("input[name^='passLast']"));
		//List <WebElement> passMeals = driver.findElements(By.cssSelector("input[name*='meal']"));
		
		for (int i=0; i<passFirst.size(); i++) {
			
			String num = Integer.toString(i);
			
			passFirst.get(i).sendKeys("FirstName"+num);
			passLast.get(i).sendKeys("LastName"+num);
			
//			WebElement meal = passMeals.get(i);
//			Select select = new Select (meal);
//			select.selectByIndex(random.nextInt(10));
			
			WebElement passMeal =  driver.findElement(By.name("pass."+num+".meal"));
			Select select = new Select (passMeal);
			select.selectByIndex(random.nextInt(10));
		}
		
		//Credit Card
		
		WebElement creditCard =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td/table/tbody/tr[2]/td[1]/select"));
		Select select_creditCard = new Select (creditCard);
		select_creditCard.selectByIndex(random.nextInt(6));
		
		WebElement cardNumber =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td/table/tbody/tr[2]/td[2]/input"));
		cardNumber.sendKeys("9999999999999999");
		
		WebElement cCexpirationDay =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td/table/tbody/tr[2]/td[3]/select[1]"));
		Select select_cCexpirationDay = new Select (cCexpirationDay);
		select_cCexpirationDay.selectByIndex(2);
		
		WebElement cCexpirationYear =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td/table/tbody/tr[2]/td[3]/select[2]"));
		Select select_cCexpirationYear = new Select (cCexpirationYear);
		select_cCexpirationYear.selectByIndex(2);
		
		WebElement cCFirstName =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td/table/tbody/tr[2]/td[1]/input"));
		cCFirstName.sendKeys("FirstName");
		
		WebElement cCMiddleName =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td/table/tbody/tr[2]/td[2]/input"));
		cCMiddleName.sendKeys("MiddleName");
		
		WebElement cCLastName =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td/table/tbody/tr[2]/td[3]/input"));
		cCLastName.sendKeys("LastName");
		
		//Billing Address
		
		WebElement ticketLessBA = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input"));
		if (ticketLessBA.isSelected()){
			ticketLessBA.click();
		}
		
		WebElement  billAdress1 =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/input"));
		billAdress1.clear();
		billAdress1.sendKeys("Adress1");
		
		WebElement  billAdress2 =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/input"));
		billAdress2.clear();
		billAdress2.sendKeys("Adress2");
		
		WebElement  billCity =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[13]/td[2]/input"));
		billCity.clear();
		billCity.sendKeys("City");
		
		WebElement  billState =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input[1]"));
		billState.clear();
		billState.sendKeys("State");
		
		WebElement  billZip =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input[2]"));
		billZip.clear();
		billZip.sendKeys("99999");
		
		WebElement billCountry =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/select"));
		Select select_billCountry = new Select (billCountry);
		select_billCountry.selectByVisibleText("MEXICO");
		
		WebElement ticketLessDA = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[16]/td[2]/input"));
		if (ticketLessDA.isSelected() == false){
			ticketLessDA.click();
		}
		
		WebElement  delAdress1 =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[17]/td[2]/input"));
		delAdress1.clear();
		
		WebElement  delCity =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[19]/td[2]/input"));
		delCity.clear();
		
		WebElement  delState =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[20]/td[2]/input[1]"));
		delState.clear();
		
		WebElement  delZip =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[20]/td[2]/input[2]"));
		delZip.clear();
		
		//Secure Purchase
		
		Thread.sleep(3000);
		
		WebElement  buyFlight =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[25]/td/input"));
		buyFlight.click();
		
		//FLIGHT CONFIRMAION
		
		Thread.sleep(3000);
		
		WebElement  logOut =  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[3]/a/img"));
		logOut.click();
		
		//SUCCESS
		
		Thread.sleep(3000);
		driver.quit();
	}

}
