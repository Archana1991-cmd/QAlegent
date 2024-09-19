package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendSalesCommissionAgentsPage {
	
   WebDriver driver;
   @FindBy(id="surname")
   WebElement Surnamebox;
   @FindBy(id="first_name")
   WebElement Firstnamebox;
   @FindBy(id="email")
   WebElement Emailbox;
   @FindBy(id="contact_no")
   WebElement ContactNo;
   @FindBy(id="cmmsn_percent")
   WebElement SalesCommissionPercentage;
   
   @FindBy(xpath="/button[text()='Save']")
   WebElement savebutton;
   
   
   
   
   public QAlegendSalesCommissionAgentsPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
   

	public void insertSalesCommissionAgentsPageQAlegent(String surname,String firstname,String email,String contactno,String salesCommissionPercentage) {
		 
			    PageUtilities.enterText(Surnamebox, surname);
				PageUtilities.enterText(Firstnamebox, firstname);
				PageUtilities.enterText(Emailbox, email);
				PageUtilities.enterText(ContactNo, contactno);
				PageUtilities.enterText(SalesCommissionPercentage , salesCommissionPercentage );

	}


	public void clickOnSavebutton() {
		        PageUtilities.clickOnElement(savebutton);
		
	}

}
