package capstone_UseCase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CapstoneScenario1Test {

  @Test
  public void mainTest() throws InterruptedException {
System.setProperty("webdriver.gecko.driver", "C://Users//Administrator//Downloads//Capstone_Project//"
		         + "geckodriver-v0.33.0-win64//geckodriver.exe");
WebDriver driver=new FirefoxDriver();
driver.get("https://automationpanda.com/");
driver.manage().window().maximize();
String HomeTitle=driver.getTitle();
System.out.println("Title of the Home page is:-" + HomeTitle);

WebElement contact=driver.findElement(By.xpath("//*[text()='Contact']"));
contact.click();
Thread.sleep(1000);
String contactTitle=driver.getTitle();
System.out.println("Title of the Contact page is:-" + contactTitle);

WebElement Name=driver.findElement(By.xpath("//*[@id='g3-name']"));
Name.sendKeys("Vivek");

WebElement Email=driver.findElement(By.xpath("//*[@id='g3-email']"));
Email.sendKeys("Vivek123@xyz.com");

WebElement Comments=driver.findElement(By.xpath("//*[@id='contact-form-comment-g3-message']"));
Comments.sendKeys("Message Sent");

WebElement SubmitBtn=driver.findElement(By.xpath("//*[text()='Contact Me']"));
SubmitBtn.click();

String ActualMessage= driver.findElement(By.xpath("//*[@id='contact-form-success-header']")).getText();
String ExpectedMessage="Your message has been sent";
Assert.assertEquals(ActualMessage, ExpectedMessage);
System.out.println("Message sent-Verification Completed");

driver.close();
   
  }
}
