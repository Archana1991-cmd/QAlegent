package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtilities;
import Utilities.PageUtilities;
import Utilities.WaitUtilities;
import Utilities.fakerUtility;

public class QAlegendUserPage {
             WebDriver driver;
             
             @FindBy(xpath="//a[@class='btn btn-block btn-primary']")
             WebElement userAddOption;
             
             @FindBy(id="surname")
             WebElement Surnamebox;
             @FindBy(id="first_name")
             WebElement Firstnamebox;
             @FindBy(id="last_name")
             WebElement Lastnamebox;
             @FindBy(id="email")
             WebElement Emailbox;
             @FindBy(id="username")
             WebElement Usernamebox;
             @FindBy(id="password")
             WebElement Passwordbox;
             @FindBy(id="confirm_password")
             WebElement Confirmpasswordbox;
             @FindBy(id="submit_user_button")
             WebElement submituserbuttonOption;
             
             @FindBy(xpath="//input[@class='form-control input-sm']")
             WebElement searchButton;

             
             @FindBy(xpath="(//button[text()=' Delete'])[1]")
             WebElement deleteUser;
             
             @FindBy(xpath="//button[text()='OK']")
             WebElement pressOkButtonToDelete;
            
             @FindBy(xpath = "//td[text()='No matching records found']")
			 WebElement errorMessege;

			 
    		
		    
			 
	public QAlegendUserPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	public void clickOnUserAddOption() {
		 
		 WaitUtilities.waitForElementTobeClickable(userAddOption, 2);
  		 PageUtilities.clickOnElement(userAddOption);
  	     }


	public void insertUserQAlegent() throws IOException {
		
		String surname=ExcelUtilities.getString(1, 0, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
		String firstname=ExcelUtilities.getString(1, 1, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
		String lastname=ExcelUtilities.getString(1, 2, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
		String email= fakerUtility.randomNumberGenerator()+ExcelUtilities.getString(1, 3, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
		String username= fakerUtility.randomNumberGenerator()+ExcelUtilities.getString(1, 4, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
		String password=ExcelUtilities.getString(1, 5, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
		String confirmpassword=ExcelUtilities.getString(1, 6, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
		
		
		
			    PageUtilities.enterText(Surnamebox, surname);
				PageUtilities.enterText(Firstnamebox, firstname);
				PageUtilities.enterText(Lastnamebox, lastname);
				PageUtilities.enterText(Emailbox, email);
				PageUtilities.enterText(Usernamebox, username);
				PageUtilities.enterText(Passwordbox, password);
				PageUtilities.enterText(Confirmpasswordbox, confirmpassword);

	}

	public void clickOnSaveButton() {
		PageUtilities.clickOnElement(submituserbuttonOption);
		
	}

     public void enterUsersearch() {
	    PageUtilities.enterText(searchButton);
     }


	 public void deleteUser() {
		PageUtilities.clickOnElement(deleteUser);
	 }
    
	 public void pressOkButtonToDelete() {
		PageUtilities.clickOnElement(pressOkButtonToDelete);
	 }

	public String noMatchingRecordsFound() {
		
		return (PageUtilities.getElementText(errorMessege));
	}

	public void clickOnUserOption() {
		//WaitUtilities.class
		
	}

	}
