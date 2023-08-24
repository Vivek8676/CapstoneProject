package capstone_UseCase1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CapstoneScenario2Test {

  @Test
  public void mainTest() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", "C://Users//Administrator//Downloads//Capstone_Project//"
		         + "geckodriver-v0.33.0-win64//geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		String HomeTitle=driver.getTitle();
		System.out.println("Title of the Home page is:-" + HomeTitle);
		Thread.sleep(2000);
		
		
		Actions actions=new Actions(driver);
		Action sendEsc=actions.sendKeys(Keys.ESCAPE).build();
		sendEsc.perform();
		
		
		WebElement Flipkart=driver.findElement(By.xpath("//*[@title='Flipkart']"));
		boolean isFlipkartPresent=Flipkart.isDisplayed();
		System.out.println("Flipkart is Present:- " + isFlipkartPresent);
		
		if(isFlipkartPresent) {
			System.out.println("Flipkart is Present on the left side of the top.");
		}
		else {
			System.out.println("Flipkart is not Present on the left side of the top.");
		}
		
		WebElement serachbox=driver.findElement(By.name("q"));
		Thread.sleep(2000);
		serachbox.sendKeys("iphone 14");
		
		WebElement serachicon=driver.findElement(By.xpath("//*[@class='_34RNph']"));
		Thread.sleep(2000);
		serachicon.click();
		
		Thread.sleep(5000);
		List<WebElement> searcheditems=driver.findElements(By.xpath("//*[@class='_4rR01T']"));
		int NumOfItems= searcheditems.size();
		System.out.println("Number of displayed items is:- " + NumOfItems );
		
		if(NumOfItems>0) {
			WebElement FirstItem= searcheditems.get(0);
			FirstItem.click();
		}
		
		String ExpectedUrl="https://www.flipkart.com/search?q=iphone%2014&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
		String ActualUrl= driver.getCurrentUrl();
		
		if(ActualUrl.equals(ExpectedUrl)) {
			System.out.println("Navigated to Right Page");
		}
		else {
			System.out.println("Navigated to Wrong Page. Expecting:" + ExpectedUrl + " , Actual: " + ActualUrl);
		}
		
		String ExpectedTitle="Iphone 14- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
		String ActualTitle=driver.getTitle();
		
		if(ActualTitle.equals(ExpectedTitle)) {
			System.out.println("Page Title is Correct");	
		}
		else {
			System.out.println("Page Title is Incorrect. Expecting:" + ExpectedTitle + " , Actual: " + ActualTitle);
			
		}
		
	}
 
  }

