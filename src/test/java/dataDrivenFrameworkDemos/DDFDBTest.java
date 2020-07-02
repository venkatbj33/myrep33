package dataDrivenFrameworkDemos;

import java.sql.*;
import java.sql.DriverManager;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDFDBTest 
{
	@Test(dataProvider = "ebayData")
	  public void CatSearch(String ddValue,String txtValue) 
	  {
		  WebDriverManager.chromedriver().version("83").setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("http://ebay.com");
		   
		  WebElement dd=driver.findElement(By.id("gh-cat"));
		  Select s=new Select(dd);
		  s.selectByVisibleText(ddValue);
		  
		  driver.findElement(By.id("gh-ac")).sendKeys(txtValue);
		  driver.findElement(By.id("gh-btn")).click();
		  
		  Reporter.log("'" + txtValue + "' Product Search in '" + ddValue + "' Category Test is Successfull...",true);
	  }

	  @DataProvider
	  public Object[][] ebayData() throws Exception
	  {
		    Object[][] data=new Object[2][2];
		    
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=myEbayDB;integratedsecurity=true");
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ebayInput");
			
			int i=0;
			while(rs.next())
			{
				data[i][0]=rs.getString(1);
				data[i][1]=rs.getString(2);
				i=i+1;
			}
		  
		  return data;
	  }
	}
