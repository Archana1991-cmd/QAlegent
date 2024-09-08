package QAlegendTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegentUserPage {
             WebDriver driver;
		     WebElement userAddOption;
			 WebElement Firstnamebox;
			 WebElement Prefixbox;
			 WebElement Lastnamebox;
			 WebElement Emailbox;
			 WebElement Usernamebox;
		     WebElement Passwordbox;
			 WebElement Confirmpasswordbox;
			 WebElement saveButton;
	public QAlegentUserPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}

	public void clickOnUserAddOption() {
		  PageUtilities.clickOnElement(userAddOption);
		
	}

	public void insertUserQAlegent(String prefix,String firstname,String lastname,String email,String username,String password,String confirmpassword) {
		 {
			    PageUtilities.enterText(Prefixbox, prefix);
				PageUtilities.enterText(Firstnamebox, firstname);
				PageUtilities.enterText(Lastnamebox, lastname);
				PageUtilities.enterText(Emailbox, email);
				PageUtilities.enterText(Usernamebox, username);
				PageUtilities.enterText(Passwordbox, password);
				PageUtilities.enterText(Confirmpasswordbox, confirmpassword);
				
		
	}

	}

	public void clickOnSaveButton() {
		PageUtilities.clickOnElement(saveButton);
		
	}

	}
