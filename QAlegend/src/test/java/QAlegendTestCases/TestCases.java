package QAlegendTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import AutomationCore.BaseClass;
import PageClasses.QAlegendLoginPage;
import PageClasses.QAlegendRolesPage;
import PageClasses.QAlegendSuppliersPage;
import PageClasses.QAlegendUnitsPage;
import PageClasses.QAlegendBrandsPage;
import PageClasses.QAlegendCategoriesPage;
import PageClasses.QAlegendCustomerPage;
import PageClasses.QAlegendHomePage;
import PageClasses.QAlegendImportProductPage;
import PageClasses.QAlegendUserPage;
import Utilities.ExcelUtilities;


public class TestCases extends BaseClass{
	
	
		WebDriver driver;
		QAlegendLoginPage loginpage;
		QAlegendHomePage homepage;
		QAlegendUserPage userpage;
		QAlegendCustomerPage customerpage;
		QAlegendRolesPage rolespage;
		QAlegendSuppliersPage supplierspage;
		QAlegendImportProductPage importproductpage;
		QAlegendBrandsPage brandspage;
		QAlegendCategoriesPage categoriespage;
		QAlegendUnitsPage unitspage;
		 Properties prop;
		 FileReader reader;
		 SoftAssert softassert;
		
		
	
		
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
			supplierspage=new QAlegendSuppliersPage(driver);
			importproductpage=new QAlegendImportProductPage(driver);
			brandspage=new QAlegendBrandsPage(driver);
			categoriespage=new QAlegendCategoriesPage(driver);
			softassert=new SoftAssert();
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
		    Assert.assertEquals(userpage.noMatchingRecordsFound(),"No matching records found");
		    softassert.assertAll();
		}
         @Test
         public  void addRoles() throws IOException, InterruptedException {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 
        	 homepage.clickOnUserManagementOption();
        	 rolespage.clickOnRolesOption();
        	 rolespage.clickOnRoleAddButton();
 			 rolespage.insertRoleName("qa tester");
             rolespage.clickOnSaveButton();
             //Assert.assertNotEquals(rolespage.insertRoleName("qa tester"),"tester");
             softassert.assertAll();
		}
         
         @Test
         public  void addSuppliers() throws IOException, InterruptedException {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 
        	  homepage.clickOnContactsOption();
        	  supplierspage.clickOnSuppliersOption();
        	  supplierspage.clickOnAddButton();
        	  
        	  Random rand=new Random();
  		      int randomnumber=rand.nextInt(10000);
  			  String contacttype=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addSuppliers.xlsx", "Sheet1");
  			  String name=ExcelUtilities.getString(1, 1, "//src//main//java//resources//addSuppliers.xlsx", "Sheet1");
  			  String businessname=ExcelUtilities.getString(1, 2, "//src//main//java//resources//addSuppliers.xlsx", "Sheet1");
  			  String mobile= randomnumber+ExcelUtilities.getNumeric(1, 3, "//src//main//java//resources//addSuppliers.xlsx", "Sheet1");
  			  supplierspage.insertSuppliers("Suppliers",name,businessname,mobile);
  			  supplierspage.clickOnSaveButton();
  			  
  		      softassert.assertAll();
        	 
		}
         @Test
       public void createCustomer() throws IOException, InterruptedException {
        	 
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 homepage.clickOnContactsOption();
        	 customerpage.clickOnCustomerOption();
        	 customerpage.clickOnCustomerAddOption();
        	 
        	 Random rand=new Random();
 		     int randomnumber=rand.nextInt(10000);
        	 String contacttype=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addACustomer.xlsx","Sheet1");
        	 String name=ExcelUtilities.getString(1, 1, "//src//main//java//resources//addACustomer.xlsx","Sheet1");
        	 String contactid=randomnumber+ExcelUtilities.getNumeric(1, 2, "//src//main//java//resources//addACustomer.xlsx","Sheet1");
        	 String mobile=ExcelUtilities.getNumeric(1, 3, "//src//main//java//resources//addACustomer.xlsx","Sheet1");
        	// customerpage.insertSuppliers("Cusomers",name,contactid,mobile);
        	 customerpage.clickOnSaveButton();
        	 softassert.assertAll();
		}
         @Test
         public  void  importProducts(Object choosefile) throws AWTException {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	
        	importproductpage.clickOnProductsOption();
        	importproductpage.clickOnImportProductsOption();
        	importproductpage.clickOnChooseFileButton();
        	 
			importproductpage.clickUsingJavaScriptExecutor(driver,choosefile);
        	
        	
        	Robot robot=new Robot();
        	robot.delay(300);
        	robot.keyPress(KeyEvent.VK_CONTROL);
        	robot.keyPress(KeyEvent.VK_V);
        	robot.keyRelease(KeyEvent.VK_V);
        	robot.keyRelease(KeyEvent.VK_CONTROL);
        	robot.keyPress(KeyEvent.VK_ENTER);
        	robot.delay(300);
        	robot.keyRelease(KeyEvent.VK_ENTER);
        	
        	importproductpage.clickOnSubmitButton();
        
		}
         
		@Test
         public void addUnits() throws IOException {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 
        	 unitspage.clickOnProductsOption();
        	 unitspage.clickOnUnitsOption();
        	 unitspage.clickOnAddbutton();
    
 			 String name=ExcelUtilities.getString(1, 0, "\\src\\main\\java\\resources\\addUnits.xlsx", "Sheet1");
 			 String shortname=ExcelUtilities.getString(1, 1, "\\src\\main\\java\\resources\\addUnits.xlsx", "Sheet1");
 			 unitspage.insertUnits(name,shortname,"Yes");
 			 unitspage.clickOnSaveButton();
 			 
 			 softassert.assertAll();
			
		}
         @Test
         public void addCategories() throws IOException {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
 			 
        	 categoriespage.clickOnProductsOption();
        	 categoriespage.clickOnCategoriesOption();
        	 categoriespage.clickOnAddButton();
        	 
        	 Random rand=new Random();
 		     int randomnumber=rand.nextInt(10000);
 			 String categoriesname=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addCategory.xlsx", "Sheet1");
 			 String categoriescode=ExcelUtilities.getString(1, 1, "//src//main//java//resources//addCategory.xlsx", "Sheet1");
 			 
 			 categoriespage.insertOnCategoriesNameBox(categoriesname);
 			 categoriespage.insertOnCategoryCodeBox(categoriescode);
 			 categoriespage.clickOnSaveButton();
 			 categoriespage.enterUsersearch("customer02398");
 			 Assert.assertEquals(categoriespage.NoMatchingRecordsFound(),"no matching records found");
			 softassert.assertAll();
  			 
 		}
         @Test
         public void addBrands() throws IOException {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 
        	 brandspage.clickOnProductsOption();
 			 brandspage.clickOnBrandsOption();
 			 brandspage.clickOnAddButton();
 			 
 			Random rand=new Random();
		    int randomnumber=rand.nextInt(10000);
			String brandname=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addBrands.xlsx", "Sheet1");
			String notes=ExcelUtilities.getString(1, 1, "//src/main//java//resources//addBrands.xlsx", "Sheet1");
 			 
 			 brandspage.insertOnBrandNameBox(brandname);
 			 brandspage.insertOnshortdiscriptionBox(notes);
 			 brandspage.clickOnSaveButton();
 			 brandspage.enterUsersearch("zudioz");
 		     Assert.assertEquals(brandspage.noMatchingRecordsFound(),"No matching records found");
 			 softassert.assertAll();
 		}
        
         
}
