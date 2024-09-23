package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendBrandsPage {
	    WebDriver driver;
	    
	    @FindBy(xpath = "(//span[@class='pull-right-container'])[3]")
	    WebElement productsoption;
	    
	    @FindBy(xpath = "//span[text()='Brands']")
	    WebElement brandsoption;
	    
	    @FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	    WebElement addbutton;
	    
	    @FindBy(id="name")
	    WebElement BrandNameBox;
	    
	    @FindBy(id = "description")
	    WebElement shortdiscriptionbox;
	    
	    @FindBy(xpath = "//button[text()='Save']")
	    WebElement savebutton;
	    
	    @FindBy(xpath = "(//input[@class='form-control input-sm'])[1]")
	    WebElement searchbutton;
	    
	    @FindBy(xpath = "//td[text()='No matching records found']")
	    WebElement errorMessege;

        public QAlegendBrandsPage(WebDriver driver) {
        	this.driver=driver;
        	PageFactory.initElements(driver, this);
        	}

        public void clickOnProductsOption() {
			PageUtilities.clickOnElement(productsoption);
			
		}

		public void clickOnBrandsOption() {
			PageUtilities.clickOnElement(brandsoption);
			
		}


		public void clickOnAddButton() {
			PageUtilities.clickOnElement(addbutton);
			
		}

		public String insertOnBrandNameBox(String brandname) {
			PageUtilities.enterText(BrandNameBox, brandname);
			return brandname;
			
		}
		 public String insertOnshortdiscriptionBox(String notes) {
			PageUtilities.enterText(shortdiscriptionbox, notes);
			return notes;
		}
		public void clickOnSaveButton() {
			PageUtilities.clickOnElement(savebutton);
			
		}
		 public void enterUsersearch(String brandname) {
			    PageUtilities.enterText(searchbutton,  brandname);
		     }

		public String noMatchingRecordsFound() {
			
			return (PageUtilities.getElementText(errorMessege));
		}

		

		
}	
