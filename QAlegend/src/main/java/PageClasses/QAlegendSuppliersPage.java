package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtilities;
import Utilities.PageUtilities;
import Utilities.fakerUtility;

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
	@FindBy(xpath ="//th[text()='Business Name']")
    WebElement Businessnamebox;
	@FindBy(xpath = "//th[text()='Business Name']")
    WebElement businessnamemesseger1;
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
	public String insertSuppliers() throws IOException {
		     String contacttype=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addSuppliers.xlsx", "Sheet1");
			 String name=ExcelUtilities.getString(1, 1, "//src//main//java//resources//addSuppliers.xlsx", "Sheet1");
			 String businessname=fakerUtility.randomNumberGenerator()+ExcelUtilities.getString(1, 2, "//src//main//java//resources//addSuppliers.xlsx", "Sheet1");
			 String mobile= fakerUtility.randomNumberGenerator()+ExcelUtilities.getNumeric(1, 3, "//src//main//java//resources//addSuppliers.xlsx", "Sheet1"); 
		
	    PageUtilities.dropdownSelectByVisibleText(Contacttype, contacttype);
		PageUtilities.enterText( Name, name);
		PageUtilities.enterText(Businessname, businessname);
		PageUtilities.enterText(Mobile, mobile);
		return businessname;
}


	public void clickOnSaveButton() {
		PageUtilities.clickOnElement(savebutton);
		
	}

	public void searchSupplierButton(String businessname) {
		PageUtilities.enterText(Businessnamebox, businessname);
	}

	public boolean businessnamemesseger() {
		
		return businessnamemesseger1.isDisplayed();
	}
	
	
	
}
