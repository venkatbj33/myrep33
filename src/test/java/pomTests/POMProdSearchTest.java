package pomTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomPages.BrowserFactory;
import pomPages.ClsEBay;

public class POMProdSearchTest
{
  @Test
  public void Search() 
  {
	  WebDriver driver=BrowserFactory.startBrowser("Chrome", "http://ebay.com");
	   
	  ClsEBay obj=new ClsEBay(driver);
	  obj.fnSearch("Sony");
	  
	  Reporter.log("Ebay Product Search Test is Successfull...",true);
  }
}
