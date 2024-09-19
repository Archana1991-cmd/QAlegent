package QAlegendTestCases;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import AutomationCore.BaseClass;
import PageClasses.QAlegendLoginPage;
import PageClasses.QAlegendRolesPage;
import PageClasses.QAlegendSalesCommissionAgentsPage;
import PageClasses.QAlegendSuppliersPage;
import PageClasses.QAlegendBrandsPage;
import PageClasses.QAlegendCategoriesPage;
import PageClasses.QAlegendCustomerPage;
import PageClasses.QAlegendHomePage;
import PageClasses.QAlegendImportProductPage;
import PageClasses.QAlegendUserPage;
import Utilities.ExcelUtilities;
import dev.failsafe.internal.util.Assert;


public class TestCases extends BaseClass{
	
		WebDriver driver;
		QAlegendLoginPage loginpage;
		QAlegendHomePage homepage;
		QAlegendUserPage userpage;
		QAlegendCustomerPage customerpage;
		QAlegendRolesPage rolespage;
		QAlegendSalesCommissionAgentsPage salescommisionagentspage;
		QAlegendSuppliersPage supplierspage;
		QAlegendImportProductPage importproductpage;
		QAlegendBrandsPage brandspage;
		QAlegendCategoriesPage categoriespage;
		 Properties prop;
		 FileReader reader;
		 String addRolename;
		
	
		
		@BeforeMethod(groups= {"smokettest","regression"})
		@Parameters({"Browser"})
		public void initialization(String browser)throws Exception 
		{
			prop=new Properties();
			reader=new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\TestData.properties");
			prop.load(reader);
			
			driver=browserInitilization(browser);
			driver.get(prop.getProperty("url"));
			//driver.get("https://qalegend.com/billing/public/login");
			driver.manage().window().maximize();
			loginpage=new QAlegendLoginPage(driver);
			homepage=new QAlegendHomePage(driver);
			userpage=new QAlegendUserPage(driver);
			customerpage=new QAlegendCustomerPage(driver);
			rolespage=new QAlegendRolesPage(driver);
			salescommisionagentspage=new QAlegendSalesCommissionAgentsPage(driver);
			supplierspage=new QAlegendSuppliersPage(driver);
			importproductpage=new QAlegendImportProductPage(driver);
			brandspage=new QAlegendBrandsPage(driver);
			categoriespage=new QAlegendCategoriesPage(driver);
		}
         @Test
		public void  createUser() throws IOException{
			//loginpage.loginToQAlegend("admin","123456");
        	loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	//homepage.clickOnEndTourButton();
			homepage.clickOnUserManagementOption();
			homepage.clickOnUserAction();
			userpage.clickOnUserAddOption();
			
			/*userpage.Surnamebox().sendKeys("Mrs");
			userpage.Firstnamebox().sendKeys("Archana");
			userpage.Lastnamebox().sendKeys("AN");
			userpage.Emailbox().sendKeys("archana@gmail.com");
			userpage.Usernamebox().sendKeys("12344");
			userpage.Passwordbox().sendKeys("archana@91");
			userpage.Confirmpassword().sendKeys("archana@91");*/
			
		    Random rand=new Random();
		    int randomnumber=rand.nextInt(10000);
			String surname=ExcelUtilities.getString(1, 0, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
			String firstname=ExcelUtilities.getString(1, 1, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
			String lastname=ExcelUtilities.getString(1, 2, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
			String email= randomnumber+ExcelUtilities.getString(1, 3, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
			String username= randomnumber+ExcelUtilities.getString(1, 4, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
			String password=ExcelUtilities.getString(1, 5, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
			String confirmpassword=ExcelUtilities.getString(1, 6, "//src//main//java//resources//userDetails.xlsx", "Sheet1");
			
			
			userpage.insertUserQAlegent(surname,firstname,lastname,email,username,password,confirmpassword);
		    //userpage.insertUserQAlegent("Mrs","Archana","AN","archana@gmail.com","10987","archana@91","archana@91");
			userpage.clickOnSaveButton(); 
			
			userpage.enterUsersearch("Archana");
			userpage.deleteUser();
			userpage.pressOkButtonToDelete();
			
			//userpage.enterUsersearch("ammutty");
		    //Assert.assertEquals(userpage.noMatchingRecordsFound(),"No matching records found");
		}
         @Test
         public  void addRoles() throws IOException {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 
        	 homepage.clickOnUserManagementOption();
        	 
        	 homepage.clickOnUserAction();
        	 
 			 homepage.clickOnRolesOption();
 			 
 			 homepage.clickOnRoleAddButton();
 			 
 			 
 			Random rand=new Random();
		    int randomnumber=rand.nextInt(10000);
			String addRolename=ExcelUtilities.getString(1, 0, "//src//main//java//resources//userDetails.xlsx", "Sheet2");
 			
			rolespage.insertRoleName(addRolename);
			//rolespage.insertRoleName("Archana");
			
			rolespage.clickOnSaveButton();
		}
         @Test
         public  void salesCommissionAgents() throws IOException {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 
             homepage.clickOnUserManagementOption();
        	 
 			 homepage.clickOnsalesCommissionAgentsOption();
 			 
 			 homepage.clickOnsalesCommissionAgentsAddButton();
 			 
 			Random rand=new Random();
		    int randomnumber=rand.nextInt(10000);
			String surname=ExcelUtilities.getString(1, 0, "src//main//java//resources//salescmmn.xlsx", "Sheet3");
			String firstname=ExcelUtilities.getString(1, 1, "src//main//java//resources//salescmmn.xlsx", "Sheet3");
			String email= randomnumber+ExcelUtilities.getString(1, 3, "src//main//java//resources//salescmmn.xlsx", "Sheet3");
			String contactno= randomnumber+ExcelUtilities.getNumeric(1, 4,"src//main//java//resources//salescmmn.xlsx", "Sheet3");
			String salesCommissionPercentage =ExcelUtilities.getString(1, 5, "src//main//java//resources//salescmmn.xlsx", "Sheet3");
			
			
 			salescommisionagentspage.clickOnSavebutton();
        	 
		}
         @Test
         public  void addSuppliers() {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 
        	  homepage.clickOnContactsOption();
        	  supplierspage.clickOnSuppliersOption();
        	 
		}
         @Test
       public void createCustomer() throws IOException {
        	 
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 
        	 customerpage.clickOnCutomerOption();
        	 customerpage.clickOnContactsButton();
        	 customerpage.dropdownSelectByVisibleText();
        	 
        	 String contactid=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addACustomer.xlsx","Sheet2");
        	 String name=ExcelUtilities.getString(1, 1, "//src//main//java//resources//addACustomer.xlsx","Sheet2");
        	 String mobile=ExcelUtilities.getString(1, 2, "//src//main//java//resources//addACustomer.xlsx","Sheet2");
        	 
		}
         @Test
         public  void  importProducts() {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	
        	importproductpage.clickOnProductsOption();
        	importproductpage.clickOnImportProductsOption();
        	importproductpage.clickOnChooseFileButton();
        	importproductpage.clickUsingJavaScriptExecutor();
        	importproductpage.setClickBoardData(null);
        	importproductpage.clickOnSubmitButton();
        		
		}
         public void addUnits() {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
			
		}
         @Test
         public void addCategories() throws IOException {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
 			 
        	 categoriespage.clickOnProductsOption();
        	 categoriespage.clickOnCategoriesOption();
        	 categoriespage.clickOnAddButton();
        	 
        	 Random rand=new Random();
 		     int randomnumber=rand.nextInt(10000);
 			 String categoriesname=ExcelUtilities.getString(1, 0, "//src//main//java//resources//userDetails.xlsx", "Sheet5");
 			 String categoriescode=ExcelUtilities.getString(1, 0, "//src//main//java//resources//userDetails.xlsx", "Sheet5");
 			 
 			 categoriespage.insertOnCategoriesNameBox(categoriesname);
 			 categoriespage.insertOnCategoryCodeBox(categoriescode);
 			 categoriespage.clickOnSaveButton();
 			 
  			 
 		}
         @Test
         public void addBrands() throws IOException {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 
        	 brandspage.clickOnProductsOption();
 			 brandspage.clickOnBrandsOption();
 			 brandspage.clickOnAddButton();
 			 
 			Random rand=new Random();
		    int randomnumber=rand.nextInt(10000);
			String brandname=ExcelUtilities.getString(1, 0, "//src//main//java//resources//userDetails.xlsx", "Sheet4");
 			 
 			 brandspage.insertOnBrandNameBox(brandname);
 			 brandspage.clickOnSaveButton(); 
 		}
         public void addPurchase() {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
     	 
        	 
 			
 		}
         
         
}
