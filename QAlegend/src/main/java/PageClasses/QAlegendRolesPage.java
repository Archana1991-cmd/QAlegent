package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendRolesPage {
       WebDriver driver;
      
       @FindBy(xpath="(//span[@class='title'])[3]")
       WebElement roles;
   	
   	   @FindBy(xpath ="//a[@class='btn btn-block btn-primary']")
       WebElement roleAddButton;
   	
   	   @FindBy(xpath = "//input[@class='form-control']")
   	   WebElement AddRoleName;
   	   
   	   @FindBy(xpath ="(//ins[@class='iCheck-helper'])[2]")
   	   WebElement userOption;
   	
   	   @FindBy(xpath = "//button[text()='Save']")
       WebElement saveButton; 
   	   
       @FindBy(xpath = "(//button[@class='btn btn-xs btn-danger delete_role_button'])[1]")
       WebElement deleteUser;
       
       @FindBy(xpath = "(//button[text()='OK'])[1]")
       WebElement deletebutton;
       
       public QAlegendRolesPage(WebDriver driver) {
     	  this.driver=driver;
   		   PageFactory.initElements(driver, this);
 	}
      

   	public void clickOnRolesOption() {
   		PageUtilities.clickOnElement(roles);
   		
   	}

   	 public void clickOnRoleAddButton() {
      		PageUtilities.clickOnElement(roleAddButton);
      		
      	}

  
	public String insertRoleName(String addrolename) {
		PageUtilities.enterText(AddRoleName, addrolename);
		return addrolename;
	}
	public void clickOnUserOption() {
		PageUtilities.clickOnElement(userOption);
		
	}
	
	 public void clickOnSaveButton() {
	   		
	   		PageUtilities.clickOnElement(saveButton);
	   		
	   	}


	public void deleteUser() {
		  PageUtilities.clickOnElement(deleteUser);
	}


	public void pressOkButtonToDelete() {
		  PageUtilities.clickOnElement(deletebutton);
		
	}

}
