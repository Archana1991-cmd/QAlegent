package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
       WebDriver driver;
       public void waitUser(WebElement user) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(user));
	   }
       public void waitRole(WebElement role) {
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   		wait.until(ExpectedConditions.elementToBeClickable(role));
   	   }
       public void waitSupplier(WebElement suppplier) {
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   		wait.until(ExpectedConditions.elementToBeClickable(suppplier));
   	   }
       public void waitCustomer(WebElement customer) {
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   		wait.until(ExpectedConditions.elementToBeClickable(customer));
   	   }
       public void waitCustomerGroup(WebElement customergroup) {
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   		wait.until(ExpectedConditions.elementToBeClickable(customergroup));
   	   }
       public void waitImportProduct(WebElement importproduct) {
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   		wait.until(ExpectedConditions.elementToBeClickable(importproduct));
   	   }
       public void waitUnits(WebElement units) {
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   		wait.until(ExpectedConditions.elementToBeClickable(units));
   	   }
       public void waitCategories(WebElement categories) {
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   		wait.until(ExpectedConditions.elementToBeClickable(categories));
   	   }
       public void waitBrands(WebElement brands) {
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   		wait.until(ExpectedConditions.elementToBeClickable(brands));
   	   }
      
}
