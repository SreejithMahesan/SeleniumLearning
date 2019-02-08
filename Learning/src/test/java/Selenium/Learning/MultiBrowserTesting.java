package Selenium.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class MultiBrowserTesting {
	public WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		} 
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\Drivers\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
			
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		driver.get("https://www.flipkart.com/");
	}
	
	@Test
	public void TestImplementation01() throws InterruptedException
	{
		System.out.println("Hello");
		Thread.sleep(10000);
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
	

}
