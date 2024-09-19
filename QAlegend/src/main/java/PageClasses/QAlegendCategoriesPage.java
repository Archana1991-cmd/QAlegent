package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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



		public String insertOnCategoriesNameBox(String categoriesname) {
			PageUtilities.enterText(CategoriesNamebox, categoriesname);
			return categoriesname;
			
		}
		public String insertOnCategoryCodeBox(String categoriescode) {
			PageUtilities.enterText(CategoriesCodebox, categoriescode);
			return categoriescode;
			
		}

        public void clickOnSaveButton() {
			PageUtilities.clickOnElement(savebutton);
			
		}
}
