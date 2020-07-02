package pomTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomPages.BrowserFactory;
import pomPages.ClsEBay;

public class POMProdCatSearchTest 
{
  @Test
  public void CatSearch() 
  {
	  WebDriver driver=BrowserFactory.startBrowser("Chrome", "http://ebay.com");
	  
	  ClsEBay obj=new ClsEBay(driver);
	  obj.fnCatSearch("Cameras & Photo", "Sony");
	  
	  Reporter.log("Ebay Product Search in a Category Test is Successfull...",true);
  }
}
