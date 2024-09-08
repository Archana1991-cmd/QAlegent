package QAlegendTestCases;

import org.openqa.selenium.WebDriver;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QAlegendLoginPage;
import PageClasses.QAlegentHomePage;


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
		public void  userCreation(){
			loginpage.loginToQAlegend("admin","123456");
			homepage.clickOnUserManagementOption();
			homepage.clickOnUserAction();
			userpage.clickOnUserAddOption();
			homepage.clickOnEndTourButton();
			
			userpage.insertUserQAlegent("Mrs","Archana","AN","archana@gmail.com","archanaan","archana@91","archana@91");
			userpage.clickOnSaveButton();
			
		}
}
