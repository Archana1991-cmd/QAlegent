package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtilities;

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
  		 PageUtilities.clickOnElement(userAddOption);
  	     }


	public void insertUserQAlegent(String surname,String firstname,String lastname,String email,String username,String password,String confirmpassword) {
		 
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

     public void enterUsersearch(String username) {
	    PageUtilities.enterText(searchButton, username);
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
