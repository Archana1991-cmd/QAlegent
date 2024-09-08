package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendLoginPage {
      
	WebDriver driver;
	
	@FindBy(id="username")
	WebElement usernametextbox;		
	
	@FindBy(id="password")
	WebElement passwordtextbox;	
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement logintbutton;	
	
	@FindBy(xpath="//button[text()='End tour']")
	WebElement endtourbutton;
	

	public QAlegendLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public void loginToQAlegend(String username,String password) {
		
		PageUtilities.enterText(usernametextbox, username);
		PageUtilities.enterText(passwordtextbox, password);
		PageUtilities.clickOnElement(logintbutton);
		PageUtilities.clickOnElement(endtourbutton);
		
	}
}
