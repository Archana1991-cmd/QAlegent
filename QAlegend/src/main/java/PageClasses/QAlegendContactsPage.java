package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendContactsPage {
	  WebDriver driver;
	
     
	  
      @FindBy(xpath="//a[@id='tour_step4_menu']")
      WebElement contactsOption;
      @FindBy(xpath="(//i[@class='fa fa-star'])[2]")                           
      WebElement customerOption;
	
      
      
      public QAlegendContactsPage(WebDriver driver) {
    	  this.driver=driver;
  		   PageFactory.initElements(driver, this);
	}



	
}
