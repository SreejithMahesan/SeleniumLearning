package Selenium.Learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UIControls {

	public static WebDriver driver;
	
	
	
		
	@BeforeClass
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority =0)
	public void LaunchBrowser()
	{
		driver.get("https://phptravels.com/");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1)
	public void closenotificationalert()
	{
		if(ExpectedConditions.alertIsPresent()== null)
		{
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}		
	
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/a[1]/span[1]/b")).click();
	}
	
	@Test(priority=2)
	public void FlightsReservation()
	{
		driver.findElement(By.cssSelector("#main-menu > ul > li:nth-child(3) > span > span")).click();
	}
	
	@AfterClass
	public void Teardown()
	{
		driver.quit();
	}
}
