package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendImportProductPage {
        WebDriver driver;
        
        @FindBy(xpath = "(//span[@class='pull-right-container'])[3]")
        WebElement products;
        
        @FindBy(xpath = "(//i[@class='fa fa-download'])[1]")
        WebElement importproducts;
        
        @FindBy(xpath = "//input[@name='products_csv']")
        WebElement choosefile;
        
        @FindBy(xpath = "//button[text()='Submit']")
    	WebElement submit;

	
        public QAlegendImportProductPage(WebDriver driver) {
        	
        		this.driver=driver;
        		PageFactory.initElements(driver, this);
        	
		}
		public void clickOnProductsOption() {
			PageUtilities.clickOnElement(products);
			
		}
		public void clickOnImportProductsOption() {
			PageUtilities.clickOnElement(importproducts);
			
		}


		public void clickOnChooseFileButton() {
			PageUtilities.clickOnElement(choosefile);
		}
		public void clickOnSubmitButton() {
			PageUtilities.clickOnElement(submit);
		}
		
		public void clickUsingJavaScriptExecutor() {
			PageUtilities.clickUsingJavaScriptExecutor(driver, choosefile);
			setClickBoardData("C:\\Users\\lenovo\\Pictures\\laptop.jpeg");
		}
		public void setClickBoardData(String string) {
			PageUtilities.clickUsingJavaScriptExecutor(driver, choosefile);
			setClickBoardData("C:\\Users\\lenovo\\Pictures\\laptop.jpeg");
			
		}
		
		
}
