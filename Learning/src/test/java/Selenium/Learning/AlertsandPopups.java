package Selenium.Learning;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AlertsandPopups {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void BeforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void AlertsMethods()
	{
	//Simple Alert
	Alert alert = driver.switchTo().alert();
	String alertMessage = alert.getText();
	alert.accept();	
	
	//Prompt Alert
	
	
	//Confirmation Alert
	}
	
	public void WindowSwitching()
	{
		//getWindowHanles()
		//getWindowHandle()
		String MainWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> i1 = allwindows.iterator();
		
		while(i1.hasNext())
		{
			String childwindow = i1.next();
			if(!MainWindow.equalsIgnoreCase(childwindow))
			{
				driver.switchTo().window(childwindow);
				driver.findElement(By.name("email")).sendKeys("emailid");
				driver.findElement(By.name("btnSubmit")).click();
				driver.close();
				driver.switchTo().window(MainWindow);
				
			}
		}				
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
		
	}	

}
