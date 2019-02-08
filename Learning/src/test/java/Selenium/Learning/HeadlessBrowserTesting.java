package Selenium.Learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.openqa.selenium.remote.



public class HeadlessBrowserTesting {
	public HtmlUnitDriver driver;
	
	/*@BeforeClass
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new HtmlUnitDriver();
		
	}*/
	
	
	@Test
	public void HeadlessTest() throws Exception
	{
		driver = new HtmlUnitDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("facebook.com");
		Thread.sleep(5000);
		element.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Facebook")).click();
		
		String Title = driver.getTitle();
		System.out.println("I am at : "+ Title);
		
		driver.quit();
		
	}
	
	/*@AfterClass
	public void Teardown()
	{
		driver.quit();
	}*/
}
