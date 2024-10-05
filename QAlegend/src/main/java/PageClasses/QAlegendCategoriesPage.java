package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtilities;
import Utilities.PageUtilities;

public class QAlegendCategoriesPage {
           WebDriver driver;
           
           @FindBy(xpath = "(//span[@class='pull-right-container'])[3]")
   	       WebElement productsoption; 
           @FindBy(xpath = "//i[@class='fa fa-tags']")
           WebElement categoriesoption;
           @FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
           WebElement addbutton;
           @FindBy(id="name")
           WebElement CategoriesNamebox;
           @FindBy(id="short_code")
           WebElement CategoriesCodebox;
           @FindBy(xpath = "//button[text()='Save']")
           WebElement savebutton;
           @FindBy(xpath = "(//input[@class='form-control input-sm'])[1]")
   	       WebElement searchbutton;
           @FindBy(xpath = "(//input[@class='form-control input-sm'])[1]")
   	       WebElement errorMessege;
   	    
           public QAlegendCategoriesPage(WebDriver driver) {
          	  this.driver=driver;
        	  PageFactory.initElements(driver, this);
      	}

        public void clickOnProductsOption() {
			  PageUtilities.clickOnElement(productsoption);
			
		}

        public void clickOnCategoriesOption() {
			  PageUtilities.clickOnElement(categoriesoption);
			
		}
        public void clickOnAddButton() {
			   PageUtilities.clickOnElement(addbutton);
			
		}



		public String insertOnCategoriesNameBox() throws IOException {
			 String categoriesname=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addCategory.xlsx", "Sheet1");
			 PageUtilities.enterText(CategoriesNamebox, categoriesname);
			 return categoriesname;
			
		}
		public void insertOnCategoryCodeBox() throws IOException {
			String categoriescode=ExcelUtilities.getString(1, 1, "//src//main//java//resources//addCategory.xlsx", "Sheet1");
			PageUtilities.enterText(CategoriesCodebox, categoriescode);
			
			
		}

        public void clickOnSaveButton() {
			PageUtilities.clickOnElement(savebutton);
			
		}
        public void enterUsersearch(String brandname) {
		    PageUtilities.enterText(searchbutton,  brandname);
	     }

		public String NoMatchingRecordsFound() {
			return (PageUtilities.getElementText(errorMessege));
		}
}
