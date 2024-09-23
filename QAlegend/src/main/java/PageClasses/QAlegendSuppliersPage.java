package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendSuppliersPage {
 
	WebDriver driver;
	
	@FindBy(xpath="(//i[@class='fa fa-star'])[1]")
	WebElement suppliersoption;
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement addbutton;
	@FindBy(xpath  = "(//*[@id='contact_type'])[2]")
	WebElement Contacttype;
	@FindBy(id ="name")
	WebElement Name;
	@FindBy(id = "supplier_business_name")
	WebElement Businessname;
	@FindBy(id = "mobile")
	WebElement Mobile;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savebutton;

	public QAlegendSuppliersPage(WebDriver driver) {
		
			this.driver=driver;
			PageFactory.initElements(driver, this);
		
	}

	public void clickOnSuppliersOption() {
		PageUtilities.clickOnElement(suppliersoption);
		
	}

	public void clickOnAddButton() {
		PageUtilities.clickOnElement(addbutton);
		
	}
	public void insertSuppliers(String contacttype,String name,String businessname,String mobile) {
		 
		PageUtilities.dropdownSelectByVisibleText(Contacttype, contacttype);
		PageUtilities.enterText( Name, name);
		PageUtilities.enterText(Businessname, businessname);
		PageUtilities.enterText(Mobile, mobile);
		
}


	public void clickOnSaveButton() {
		PageUtilities.clickOnElement(savebutton);
		
	}
	
	
	
}
