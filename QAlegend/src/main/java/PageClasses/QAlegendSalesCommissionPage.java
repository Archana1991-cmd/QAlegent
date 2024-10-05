package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtilities;
import Utilities.PageUtilities;
import Utilities.fakerUtility;

public class QAlegendSalesCommissionPage {
	
	WebDriver driver;
	@FindBy(xpath = "//span[text()='User Management']")
	WebElement usermanagementoption;
	@FindBy(xpath = "(//span[@class='title'])[4]")
	WebElement salescommission;
	@FindBy(xpath = "//button[@class='btn btn-primary btn-modal pull-right']")
	WebElement addbutton;
	@FindBy(id = "surname")
	WebElement Prefix;
	@FindBy(id = "first_name")
	WebElement Firstname;
	@FindBy(id = "email")
	WebElement Email;
	@FindBy(id = "contact_no")
	WebElement Contactno;
	@FindBy(id = "address")
	WebElement Address;
	@FindBy(id = "cmmsn_percent")
	WebElement Commissionpercentage;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement savebutton;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement Searchbutton;
	@FindBy(xpath =  "(//(tr[@role='row']//td)[2]")
	WebElement successmessage;
	
	public QAlegendSalesCommissionPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	public void clickOnUserManagementOption() {
		 PageUtilities.clickOnElement(usermanagementoption);
		
	}

	public void clickOnsalesCommissionOption() {
		 PageUtilities.clickOnElement(salescommission);
		
	}

	public void clickOnAddSalesButton() {
		 PageUtilities.clickOnElement(addbutton);
		
	}

	public String insertSalescommissionDetails(String excelfilepath1, String sheetname) throws IOException {
		 String prefix=ExcelUtilities.getString(1, 0, "\\src\\main\\java\\resources\\addSalesCommission.xlsx", "Sheet1");
		 String firstname=ExcelUtilities.getString(1, 1, "\\src\\main\\java\\resources\\addSalesCommission.xlsx", "Sheet1");
		 String email=fakerUtility.randomNumberGenerator()+ExcelUtilities.getString(1, 2, "\\src\\main\\java\\resources\\addSalesCommission.xlsx", "Sheet1");
		 String contactno= ExcelUtilities.getNumeric(1, 3, "\\src\\main\\java\\resources\\addSalesCommission.xlsx", "Sheet1");
		 String address=ExcelUtilities.getString(1, 4, "\\src\\main\\java\\resources\\addSalesCommission.xlsx", "Sheet1");
		 String commissionpercentage=ExcelUtilities.getNumeric(1, 5, "\\src\\main\\java\\resources\\addSalesCommission.xlsx", "Sheet1");
		 
		PageUtilities.enterText(Prefix, prefix);
		PageUtilities.enterText(Firstname, firstname);
		PageUtilities.enterText(Email, email);
		PageUtilities.enterText(Contactno, contactno);
		PageUtilities.enterText(Address, address);
		PageUtilities.enterText(Commissionpercentage, commissionpercentage);
		return email;
	}

	public void clickOnsaveButton() {
		PageUtilities.clickOnElement(savebutton);
		
	}

	public void searchCommissionAgent(String email) {
		PageUtilities.enterText(Searchbutton, email);
		
	}

	public boolean emailCellFinder() {
		
		return successmessage.isDisplayed();
	}

	
	
}
