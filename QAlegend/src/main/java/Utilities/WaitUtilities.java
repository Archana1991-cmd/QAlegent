package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
       static WebDriver driver;
       
       public WaitUtilities(WebDriver driver) {
  		 this.driver=driver;
  		 
  	}
       public static void waitForElementVisibility(WebElement element,int timeoutInSeconds) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	   }
       public static void waitForElementTobeClickable(WebElement element,int timeoutInSeconds) {
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
   		wait.until(ExpectedConditions.elementToBeClickable(element));
   	   }
       public static void waitForPageTitle(String title,int timeoutInSeconds) {
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
   		wait.until(ExpectedConditions.titleIs(title));
   	   }
       public static void waitForAlertToBePresent(String title,int timeoutInSeconds) {
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
   		wait.until(ExpectedConditions.alertIsPresent());
   	   }
       public static void waitForAFrameoBeAvailableAndSwitchToIt(int timeoutInSeconds,WebElement element) {
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
   	   }
       public static void waitForTextToBePresent(int timeoutInSeconds,WebElement element,String value) {
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
   		wait.until(ExpectedConditions.textToBePresentInElement(element, value));
   	   }
       
      
}
