package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendCustomerPage {
   WebDriver driver;
   @FindBy(xpath = "//li[@class='active']")
   WebElement customerOption;
   
   WebElement contactsOption;
   
   @FindBy(xpath="(//i[@class='fa fa-plus'])[1]")
   WebElement customerAddOption;
   
   
   public void clickOnCustomerAddOption() {
		
		  PageUtilities.clickOnElement(customerAddOption);
	}
   
   public void contacttype() {
	 PageUtilities.dropdownSelectByVisibleText(customerOption, null);
}
   
   @FindBy(id="name")
   WebElement Namebox;
   @FindBy(id="mobile")
   WebElement Mobilebox;
 
   @FindBy(xpath="//button[text()='Save']")
   WebElement Savebutton;
   WebElement Contacttype;
   String customer;


   
   
   public QAlegendCustomerPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}

	

	public void insertUserQAlegent(String name,String mobile) {
		 
			    PageUtilities.enterText(Namebox, name);
				PageUtilities.enterText(Mobilebox, mobile);
				
		 }


    public void clickOnCutomerOption() {
		PageUtilities.clickOnElement(customerOption);
	}
    
	public void clickOnCustomersButton() {
		PageUtilities.clickOnElement(customerOption);
		
	}

	public void clickOnContactsButton() {
		PageUtilities.clickOnElement(contactsOption);
		
	}	
	public void clickOnSaveButton() {
		PageUtilities.clickOnElement(Savebutton);
		
	}

	public void dropdownSelectByVisibleText() {
		PageUtilities.dropdownSelectByVisibleText(Contacttype, customer);
	}

	
}
