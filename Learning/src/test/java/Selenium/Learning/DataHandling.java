package Selenium.Learning;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataHandling {
	
	public static WebDriver driver;	
	
	@BeforeClass
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	//******************* Using Parameter *************************
	@Test
	@Parameters({"UserName","Passwordtxt"})
	public void ParameterTest(String UserName,String Passwordtxt)
	{
		System.out.println("UserName is: "+ UserName);
		System.out.println("Password is  :"+ Passwordtxt);
	}
	
	
	//************************ Using DataProvider  ****************
	@Test(dataProvider = "dataProvider01")
	public void DataproviderTest(int number,int expected)
	{
		Assert.assertEquals(number, expected);
	}
	
	
	@DataProvider(name = "dataProvider01")
	public Object[][]provideData(Method method)
	{
		Object[][]result = null;
		result = new Object[][] {{1,1},{300,300}};
		return result;
	}
	
	@AfterClass
	public void Teardown()
	{
		driver.quit();
	}

}
