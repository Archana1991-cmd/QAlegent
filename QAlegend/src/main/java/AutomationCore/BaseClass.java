package AutomationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
		 public WebDriver driver;
		   
		   public WebDriver browserInitilization(String browsername)
		   {
			   if (browsername.equalsIgnoreCase("Chrome"))
			   {
				   driver=new ChromeDriver();
			   }else if (browsername.equalsIgnoreCase("Edge"))
			   {
				   driver=new EdgeDriver();
				  // driver.manage().timeouts().implicitlyWait(2,TimeUnit.DAYS);
			   }else if (browsername.equalsIgnoreCase("firefox"))
			   {
				   driver=new FirefoxDriver();
			   }else
			   {
				   System.out.println("Invalid browser");
			   }
			   return driver;
		   
		   }
}