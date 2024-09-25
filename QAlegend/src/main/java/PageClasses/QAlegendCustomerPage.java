package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendCustomerPage {
   WebDriver driver;
   
   @FindBy(id="tour_step4_menu")
   WebElement contactsoption;
   @FindBy(xpath = "(//i[@class='fa fa-star'])[2]")
   WebElement customerOption;
   @FindBy(xpath="(//i[@class='fa fa-plus'])[1]")
   WebElement customerAddOption;
   @FindBy(id = "contact_type")
   WebElement Contacttypebox;
   @FindBy(id = "name")
   WebElement Namebox;
   @FindBy(id = "contact_id")
   WebElement Contactidbox;
   @FindBy(id="mobile")
   WebElement Mobilebox;
 
   @FindBy(xpath="//button[text()='Save']")
   WebElement Savebutton;
   
   
   public QAlegendCustomerPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
   public void clickOnContactsoption() {
	    PageUtilities.clearText(contactsoption);
    }
   public void clickOnCustomerOption() {
		PageUtilities.clickOnElement(customerOption);
	}
   public void clickOnCustomerAddOption() {
	    PageUtilities.clickOnElement(customerAddOption);
	}
 
	public void insertSuppliers(String contacttype, String name, String contactid, String mobile) {
		PageUtilities.dropdownSelectByVisibleText(Contacttypebox, contacttype);
		PageUtilities.enterText(Namebox, name);
		PageUtilities.enterText(Contactidbox, contactid);
		PageUtilities.enterText(Mobilebox, mobile);
	}
    public void clickOnSaveButton() {
		PageUtilities.clickOnElement(Savebutton);
	}

	
}
