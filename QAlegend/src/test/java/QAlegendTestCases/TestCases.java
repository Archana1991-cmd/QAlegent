package QAlegendTestCases;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QAlegendLoginPage;
import PageClasses.QAlegentHomePage;
import Utilities.ExcelUtilities;


public class TestCases extends BaseClass{
	
		public WebDriver driver;
		QAlegendLoginPage loginpage;
		QAlegentHomePage homepage;
		QAlegentUserPage userpage;
		
		@BeforeMethod(groups= {"smokettest","regression"})
		@Parameters({"Browser"})
		public void initialization(String browser)throws Exception
		{

			driver=browserInitilization(browser);
			driver.get("https://qalegend.com/billing/public/login");
			driver.manage().window().maximize();
			loginpage=new QAlegendLoginPage(driver);
			homepage=new QAlegentHomePage(driver);
			userpage=new QAlegentUserPage(driver);
			
		}
         @Test
		public void  userCreation() throws IOException{
			loginpage.loginToQAlegend("admin","123456");
			homepage.clickOnUserManagementOption();
			homepage.clickOnUserAction();
			userpage.clickOnUserAddOption();
			homepage.clickOnEndTourButton();
			
		    Random rand=new Random();
		    int randomnumber=rand.nextInt(10000);
			String prefix=ExcelUtilities.getString(1, 0, "\\src\\main\\java\\resources", "Sheet1");
			String firstname=ExcelUtilities.getString(1, 1, "\\src\\main\\java\\resources", "Sheet1");
			String lastname=ExcelUtilities.getString(1, 2, "\\src\\main\\java\\resources", "Sheet1");
			String email=ExcelUtilities.getString(1, 3, "\\src\\main\\java\\resources", "Sheet1");
			String username=ExcelUtilities.getString(1, 4, "\\src\\main\\java\\resources", "Sheet1");
			String password=ExcelUtilities.getString(1, 5, "\\src\\main\\java\\resources", "Sheet1");
			String confirmpassword=ExcelUtilities.getString(1, 6, "\\src\\main\\java\\resources", "Sheet1");
			
			//userpage.insertUserQAlegent("Mrs","Archana","AN","archana@gmail.com","archanaan","archana@91","archana@91");
			userpage.clickOnSaveButton();
			
		}
}
