package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendCustomerGroupPage {
         WebDriver driver;
        @FindBy(xpath = "(//i[@class='fa fa-users'])[2]")
        WebElement customergroupoption;
        @FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
        WebElement addoption;
        @FindBy(id = "name")
        WebElement CustomerGroupName;
        @FindBy(id = "amount")
        WebElement CalculationPercentage;
        @FindBy(xpath = "//button[text()='Save']")
        WebElement savebutton;
        @FindBy(xpath = "//input[@class='form-control input-sm']")
        WebElement searchbutton;
         
         
		public QAlegendCustomerGroupPage(WebDriver driver) {
			this.driver=driver;
	   		   PageFactory.initElements(driver, this);
		}

		public void clickOnCustomerGroupOption() {
			PageUtilities.clickOnElement(customergroupoption);
			
		}

		public void clickOnCustomerGroupAddOption() {
			PageUtilities.clickOnElement(addoption);
			
		}

		public void insertCustomerGroup(String customergroupname, String calculationpercentage) {
			PageUtilities.enterText(CustomerGroupName, customergroupname);
			PageUtilities.enterText(CalculationPercentage, calculationpercentage);
		
		}

		public void clickOnSaveButton() {
			PageUtilities.clickOnElement(savebutton);
			
		}

		public void clickOnSearchButton() {
			PageUtilities.clickOnElement(searchbutton);
			
		}
}
