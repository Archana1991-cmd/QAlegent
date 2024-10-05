package QAlegendTestCases;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import AutomationCore.BaseClass;
import PageClasses.QAlegendLoginPage;
import PageClasses.QAlegendRolesPage;
import PageClasses.QAlegendSalesCommissionPage;
import PageClasses.QAlegendSuppliersPage;
import PageClasses.QAlegendUnitsPage;
import PageClasses.QAlegendBrandsPage;
import PageClasses.QAlegendCategoriesPage;
import PageClasses.QAlegendCustomerGroupPage;
import PageClasses.QAlegendCustomerPage;
import PageClasses.QAlegendHomePage;
import PageClasses.QAlegendUserPage;
import Utilities.ExcelUtilities;
import Utilities.fakerUtility;


public class TestCases extends BaseClass{
	
		 private static final String gmail = null;
		WebDriver driver;
		 QAlegendLoginPage loginpage;
		 QAlegendHomePage homepage;
		 QAlegendUserPage userpage;
		 QAlegendCustomerPage customerpage;
		 QAlegendRolesPage rolespage;
		 QAlegendSalesCommissionPage salescommissionpage;
		 QAlegendSuppliersPage supplierspage;
		 QAlegendBrandsPage brandspage;
		 QAlegendCategoriesPage categoriespage;
		 QAlegendUnitsPage unitspage;
		 QAlegendCustomerGroupPage customergrouppage;
		 Properties prop;
		 FileReader reader;
		 String addrolename;
		
	
		
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
			salescommissionpage=new QAlegendSalesCommissionPage(driver);
			supplierspage=new QAlegendSuppliersPage(driver);
			unitspage=new QAlegendUnitsPage(driver);
			brandspage=new QAlegendBrandsPage(driver);
			categoriespage=new QAlegendCategoriesPage(driver);
			customergrouppage=new QAlegendCustomerGroupPage(driver);
			
		}
         @Test(retryAnalyzer = RetryAnalyzer.class)
		public void  verifyAddUser() throws IOException{
			
        	loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
			homepage.clickOnUserManagementOption();
			homepage.clickOnUserAction();
			userpage.clickOnUserAddOption();
			
			userpage.insertUserQAlegent();
			userpage.clickOnSaveButton(); 
		    userpage.enterUsersearch();
		
		    Assert.assertEquals(userpage.noMatchingRecordsFound(),"No matching records found");
		    
		}
         @Test(retryAnalyzer = RetryAnalyzer.class,groups= {"smoketest"})
         public void  verifyDeleteUser() throws IOException{
 			
         	loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
 			homepage.clickOnUserManagementOption();
 			homepage.clickOnUserAction();
 			userpage.clickOnUserAddOption();
 			
 			userpage.clickOnUserOption();
 			 			
 			userpage.insertUserQAlegent();
 			userpage.clickOnSaveButton(); 
 		    userpage.enterUsersearch();
 			userpage.deleteUser();
 			userpage.pressOkButtonToDelete();
 			//userpage.enterUsersearch("ammutty");
 		    Assert.assertEquals(userpage.noMatchingRecordsFound(),"No matching records found");
 		    
 		}
         @Test (retryAnalyzer = RetryAnalyzer.class,groups= {"smoketest"})
         public  void verifyAddRoles() throws IOException, InterruptedException {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 homepage.clickOnUserManagementOption();
        	 rolespage.clickOnRolesOption();
        	 rolespage.clickOnRoleAddButton();
 			 rolespage.insertRoleName("qa tester");
 			 rolespage.clickOnUserOption();
             rolespage.clickOnSaveButton();
             rolespage.deleteUser();
 			 rolespage.pressOkButtonToDelete();
 		     userpage.enterUsersearch(addrolename);
             Assert.assertNotEquals(rolespage.insertRoleName("qa tester"),addrolename);
             
		}
         @Test(retryAnalyzer = RetryAnalyzer.class)
         public void verifyAddSalesCommission() throws IOException{
        	

        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 salescommissionpage.clickOnUserManagementOption();
 			 salescommissionpage.clickOnsalesCommissionOption();
 			 salescommissionpage.clickOnAddSalesButton();
 			 
 			 String email=salescommissionpage.insertSalescommissionDetails(excelfilepath1,"Sheet1");
 		     salescommissionpage.clickOnsaveButton();
 			 
			 salescommissionpage.searchCommissionAgent(email);
 			 System.out.println(salescommissionpage.emailCellFinder());
 			 Assert.assertEquals(salescommissionpage.emailCellFinder(),email);
 			 System.out.println("Testcase salescommission passed");
		}
         @Test(retryAnalyzer = RetryAnalyzer.class)
         public  void verifyAddSuppliers() throws IOException, InterruptedException {
        	
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 homepage.clickOnContactsOption();
        	 supplierspage.clickOnSuppliersOption();
        	 supplierspage.clickOnAddButton();
             
  		     
  			 String businessname=supplierspage.insertSuppliers();
  			 supplierspage.clickOnSaveButton();
  			 supplierspage.searchSupplierButton(businessname);
  			 Assert.assertEquals(supplierspage.businessnamemesseger(),businessname);
  		    
		}
         @Test(retryAnalyzer = RetryAnalyzer.class)
       public void verifyAddCustomer() throws IOException, InterruptedException {
        	 
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 homepage.clickOnContactsOption();
        	 customerpage.clickOnCustomerOption();
        	 customerpage.clickOnCustomerAddOption();
        	 
        	
        	 customerpage.insertSuppliers("Custmers",name,contactid,mobile);
        	 customerpage.clickOnSaveButton();
        	 customerpage.searchbutton(name);
        	 Assert.assertEquals(customerpage.namebox(name), name);
        	 
        	 
		} 
         @Test(retryAnalyzer = RetryAnalyzer.class)
         public void verifyAddCustomerGroup() throws IOException {
        	 
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 homepage.clickOnContactsOption();
        	 customergrouppage.clickOnCustomerGroupOption();
        	 customergrouppage.clickOnCustomerGroupAddOption();
        	 
        	 String customergroupname=customergrouppage.insertCustomerGroup();
        	 customergrouppage.clickOnSaveButton();
 			 customergrouppage.searchcreateCustomerGroup(customergroupname);
			 Assert.assertEquals(customergrouppage.Customergroupbox(customergroupname),customergroupname);
 			 
		}
         
        
         
		@Test(retryAnalyzer = RetryAnalyzer.class)
         public void verifyAddUnits() throws IOException {
        	 
			 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 unitspage.clickOnProductsOption();
        	 unitspage.clickOnUnitsOption();
        	 unitspage.clickOnAddbutton();
             
 			 String name=unitspage.insertUnits();
 			 unitspage.clickOnSaveButton();
 			 unitspage.enterUserSearchbutton(name);
 			 Assert.assertEquals(unitspage.noMatchingRecordsFound(),name);
		}
         @Test(retryAnalyzer = RetryAnalyzer.class)
         public void verifyAddCategories() throws IOException {
        	 
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
 			 categoriespage.clickOnProductsOption();
        	 categoriespage.clickOnCategoriesOption();
        	 categoriespage.clickOnAddButton();
 		
 	         String categoriesname=categoriespage.insertOnCategoriesNameBox();
 			 categoriespage.insertOnCategoryCodeBox();
 			 categoriespage.clickOnSaveButton();
 			 categoriespage.enterUsersearch(categoriesname);
 			 Assert.assertEquals(categoriespage.NoMatchingRecordsFound(),categoriesname);
 		}
         @Test(retryAnalyzer = RetryAnalyzer.class)
         public void verifyAddBrands() throws IOException {
        	 
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 brandspage.clickOnProductsOption();
 			 brandspage.clickOnBrandsOption();
 			 brandspage.clickOnAddButton();
 			 String brandname=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addBrands.xlsx", "Sheet1");
			 String notes=ExcelUtilities.getString(1, 1, "//src/main//java//resources//addBrands.xlsx", "Sheet1"); 
 			 brandspage.insertOnBrandNameBox(brandname);
 			 brandspage.insertOnshortdiscriptionBox(notes);
 			 brandspage.clickOnSaveButton();
 			 brandspage.enterUsersearch(fakerUtility.randomNumberGenerator()+brandname);
 		     Assert.assertEquals(brandspage.MatchingRecordsFound(),true);   
 		}
         
}
