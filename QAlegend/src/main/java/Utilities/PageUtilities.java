package Utilities;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	

	public static void clickOnElement(WebElement element) 
	{
		element.click();
	}
	public static void enterText(WebElement element,String value) {
		
		element.sendKeys(value);
	}
	public static String getElementText(WebElement element) {
		
		return(element.getText());
	}
	public static String  getAttribute(WebElement element, String attributename) {
		
		return (element.getAttribute(attributename));
	}
	public static void clearText(WebElement element) {
		element.clear();
	}
	public static void navigateToBack(WebDriver driver) {
		driver.navigate().back();
	}
	public static void navigateToForward(WebDriver driver) {
		driver.navigate().forward();
	}
	public static void navigateToRefresh(WebDriver driver,String value) {
		driver.navigate().refresh();
	}
	public static void navigateTo(WebDriver driver,String url) {
		driver.navigate().to(url);
	}
	
	public static void moveToElement(WebElement element,WebDriver driver) {
		Actions action=new Actions(driver);
		action.moveToElement(element);
		action.build().perform();
	}
	public static void dropdownSelectByIndex(WebElement element,int index) {
		Select drp1=new Select(element);
		drp1.selectByIndex(index);
	}
	public static void dropdownSelectByValue(WebElement element,String value) {
		Select drp2=new Select(element);
		drp2.selectByValue(value);
	}
	public static void dropdownSelectByVisibleText(WebElement element,String value) {
		Select drp3=new Select(element);
		drp3.selectByVisibleText(value);
	}
	
	public static boolean isElementDisplayed(WebElement element) {
		return (element.isDisplayed());	
	}
	
	public static boolean isElementEnabled(WebElement element) {
		return (element.isEnabled());	
	}
	
	public static boolean isElementSelected(WebElement element) {
		return (element.isSelected());	
	}
	
	public static String getPageTitle(WebDriver driver) {
		return (driver.getTitle());
		
	}
	
	public static void clickUsingJavaScriptExecutor(WebDriver driver,WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("argument[0]", element);
		
	}
	public void setClickBoardData(String path) {
		StringSelection stringSelection=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
	}	
	
	public static void scrollBy(WebDriver driver) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy(0,1000)");
	}
	
	public static void enterKeyPress(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.sendKeys(element,Keys.ENTER);
		action.build().perform();
	}
	
	
}

