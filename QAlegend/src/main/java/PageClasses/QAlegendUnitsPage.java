package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtilities;
import Utilities.PageUtilities;

public class QAlegendUnitsPage {
	WebDriver driver;
     
	@FindBy(xpath = "(//span[@class='pull-right-container'])[3]")
    WebElement productsoption;
    @FindBy(xpath = "(//span[text()='Units'])[1]")
    WebElement unitsoption;
    @FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
    WebElement addbutton;
    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    WebElement Name;
    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    WebElement Shortname;
    @FindBy(id = "allow_decimal")
    WebElement Allowdecimal;
    @FindBy(xpath = "//button[text()='Save']")
    WebElement savebutton;
    @FindBy(xpath = "//input[@class='form-control input-sm']")
    WebElement Searchbutton;
    @FindBy(xpath = "//td[text()='No matching records found']")
    WebElement errorMessege;
    
    
    public QAlegendUnitsPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	
    
	public void clickOnProductsOption() {
		PageUtilities.clickOnElement(productsoption);
		
	}

	public void clickOnUnitsOption() {
		PageUtilities.clickOnElement(unitsoption);
		
	}

	public void clickOnAddbutton() {
		PageUtilities.clickOnElement(addbutton);
	}
	
	
	public String insertUnits() throws IOException {
		 String name=ExcelUtilities.getString(1, 0, "\\src\\main\\java\\resources\\addUnits.xlsx", "Sheet1");
		 String shortname=ExcelUtilities.getString(1, 1, "\\src\\main\\java\\resources\\addUnits.xlsx", "Sheet1");
		 String allowdecimal=ExcelUtilities.getString(1, 2, "\\src\\main\\java\\resources\\addUnits.xlsx", "Sheet1");
		PageUtilities.enterText(Name, name);
		PageUtilities.enterText(Shortname, shortname);
		PageUtilities.dropdownSelectByVisibleText(Allowdecimal, allowdecimal);
		return name;
	}

	public void clickOnSaveButton() {
		PageUtilities.clickOnElement(savebutton);
		
	}

	public void enterUserSearchbutton(String searchbutton) {
		PageUtilities.enterText(Searchbutton,searchbutton);
		
	}


	public String noMatchingRecordsFound() {
		return (PageUtilities.getElementText(errorMessege));

	}

}
