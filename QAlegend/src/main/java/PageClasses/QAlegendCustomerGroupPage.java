package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtilities;
import Utilities.PageUtilities;
import Utilities.WaitUtilities;

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
        WebElement searchTextBox;
        @FindBy(xpath = "//th[@class='sorting_asc']")
        WebElement Customergroupbox;
         
         
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

		public String insertCustomerGroup() throws IOException {
			
			String customergroupname=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addACustomerGroup.xlsx","Sheet1");
       	    String calculationpercentage=ExcelUtilities.getNumeric(1, 1, "//src//main//java//resources//addACustomerGroup.xlsx","Sheet1");
			PageUtilities.enterText(CustomerGroupName, customergroupname);
			PageUtilities.enterText(CalculationPercentage, calculationpercentage);
		    return customergroupname;
		}

		public void clickOnSaveButton() {
			PageUtilities.clickOnElement(savebutton);
			
		}

		public void searchcreateCustomerGroup(String customergroupname) {
			WaitUtilities.waitForElementVisibility(searchTextBox, 5);
			PageUtilities.clickOnElement(searchTextBox);
		}

		public String Customergroupbox(String customergroupname) {
			//PageUtilities.enterText(Customergroupbox, customergroupname);
			return customergroupname;
		}
}
