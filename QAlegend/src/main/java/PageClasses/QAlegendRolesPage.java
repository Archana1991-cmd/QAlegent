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
   	
   	   @FindBy(xpath="//a[@class='btn btn-block btn-primary']")
       WebElement roleAddButton;
   	
   	   @FindBy(xpath = "//input[@class='form-control']")
   	   WebElement AddRoleName;
   	
   	   @FindBy(xpath = "//button[text()='Save']")
       WebElement saveButton; 
       
       
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

  
	public void insertRoleName(String addRolename) {
		PageUtilities.enterText(AddRoleName, addRolename);
	}
	
	
	 public void clickOnSaveButton() {
	   		
	   		PageUtilities.clickOnElement(saveButton);
	   		
	   	}


}
