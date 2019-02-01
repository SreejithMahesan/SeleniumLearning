package Selenium.Learning;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SeleniumWaits {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void BeforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void ImpcitWaitsLearning()
	{
	/*	Common to all controls
		Default time is 0
		Waits till the specified time before throwing "No Such Element Exception"*/
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	
	public void ExplicitWaitLearning()
	{
//		Used for telling webdriver to wait until expected conditions
		
		WebElement expandIcon = driver.findElement(By.xpath("//*[@id=\"securePrintButton\"]"));
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		explicitWait.until(ExpectedConditions.visibilityOf(expandIcon));
	}
	
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
	public WebElement apply(WebDriver driver)
	{
		return driver.findElement(By.xpath("some path"));
		
	}

	
	@AfterTest
	public void teardown()
	{
		driver.quit();
		
	}

}
