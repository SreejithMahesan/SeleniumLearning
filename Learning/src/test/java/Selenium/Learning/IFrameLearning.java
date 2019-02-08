package Selenium.Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IFrameLearning {
	WebDriver driver;
	
	@BeforeTest
	public void BeforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void TestFrame01()
	{
//		int size = driver.findElement(By.tagName("iframe")).size();
		
		driver.switchTo().frame(0);		
		driver.switchTo().frame("a0077aa5e");
		driver.switchTo().frame("WebElement");
		
		
		//Switch back to parent
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		
	}
	
	
	@Test
	public void NestedFramesTest()
	{
		
	}

	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
}
