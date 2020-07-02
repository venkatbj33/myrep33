package dataDrivenFrameworkDemos;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DDFProdSearchTest 
{
  @Test(dataProvider = "ebayData")
  public void Search(String ddValue,String txtValue) 
  {
	  WebDriverManager.chromedriver().version("83").setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://ebay.com");
	   
	  driver.findElement(By.id("gh-ac")).sendKeys(txtValue);
	  driver.findElement(By.id("gh-btn")).click();
	  
	  Reporter.log("'" + txtValue + "' Product Search Test is Successfull...",true);
  }

  @DataProvider
  public Object[][] ebayData() throws Exception
  {
	  Object[][] myData=null;
	  
	  XSSFWorkbook wb=new XSSFWorkbook(System.getProperty("user.dir") + "\\src\\test\\resources\\ebayData.xlsx");
	  XSSFSheet ws=wb.getSheet("Sheet1");
	  int rows=ws.getPhysicalNumberOfRows();
	  
	  myData=new Object[rows][2];
	  
	  for(int i=0;i<rows;i++)
	  {
		  myData[i][0]=ws.getRow(i).getCell(0).getStringCellValue();
		  myData[i][1]=ws.getRow(i).getCell(1).getStringCellValue();
	  }
	  
	  return myData;
  }
}
