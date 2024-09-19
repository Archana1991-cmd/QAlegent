package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendSuppliersPage {
 
	WebDriver driver;
	
	@FindBy(xpath="(//i[@class='fa fa-star'])[1]'")
	WebElement suppliersoption;

	public QAlegendSuppliersPage(WebDriver driver) {
		
			this.driver=driver;
			PageFactory.initElements(driver, this);
		
	}

	public void clickOnSuppliersOption() {
		PageUtilities.clickOnElement(suppliersoption);
		
	}
	
	
	
}
