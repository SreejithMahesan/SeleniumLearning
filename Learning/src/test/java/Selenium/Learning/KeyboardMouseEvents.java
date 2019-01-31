package Selenium.Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class KeyboardMouseEvents {
	WebDriver driver;
	@BeforeTest
	public void BeforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void KeyboardAndMouseEvents()
	{
		
		WebElement logo = driver.findElement(By.xpath("img[@name='logo'"));
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(logo).build();
		mouseOverHome.perform();
		
		//Series of Actions
		Action seriesofActions = builder
								.moveToElement(logo)
								.click()
								.doubleClick()
								.keyDown(logo,Keys.SHIFT)
								.keyUp(logo,Keys.SHIFT)
								.build();
		seriesofActions.perform();
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}

}
