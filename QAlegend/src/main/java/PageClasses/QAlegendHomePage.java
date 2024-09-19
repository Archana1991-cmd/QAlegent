package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendHomePage {
 
	WebDriver driver;
	
	
	@FindBy(xpath="//span[text()='User Management']")
	WebElement userManagementOption;
	
	@FindBy(xpath="//span[@class='title']//preceding::i[@class='fa fa-user']")
	WebElement usersOption;
	
	@FindBy(xpath="//button[text()='End tour']")
	WebElement endTourButton;
	
	@FindBy(xpath="(//span[@class='title'])[3]")
    WebElement roles;
	
	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
    WebElement roleAddButton;
	   
	@FindBy(xpath = "(//span[@class='title'])[4]")
	WebElement salescommissionAgentsOption;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-modal pull-right']")
	WebElement salescommissionAgentsaddOption;
	
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactsoption;
	
	public void clickOnUserManagementOption() {
		PageUtilities.clickOnElement(userManagementOption);
	}
	
	public void clickOnUserAction() {
		PageUtilities.clickOnElement(usersOption);
	}
	
	public void clickOnEndTourButton() {
		PageUtilities.clickOnElement(endTourButton);
	}
	
	public QAlegendHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnRolesOption() {
		PageUtilities.clickOnElement(roles);
		
	}

	 public void clickOnRoleAddButton() {
   		PageUtilities.clickOnElement(roleAddButton);
   		
   	}

	public void clickOnsalesCommissionAgentsOption() {
		PageUtilities.clickOnElement(salescommissionAgentsOption);
		
	}

	public void clickOnsalesCommissionAgentsAddButton() {
		PageUtilities.clickOnElement(salescommissionAgentsaddOption);
		
	}

	public void clickOnContactsOption() {
		PageUtilities.clickOnElement(contactsoption);
		
	}

	
	
	
}
