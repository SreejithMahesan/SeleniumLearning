package Selenium.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Selenium.Learning.TestNgListnersLearning.class)

public class TestNGLearning {
	
WebDriver driver;
	
	
	@BeforeTest
	public void BeforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority =0,enabled=true)
	public void Test01()
	{
		System.out.println("This is the first test");
		
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
		
	}	

}
