package Selenium.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLibrary {
	
	public static WebDriver driver;
	
	
	public void InitiateDriver()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void QuitDriver()
	{
		driver.quit();
	}

}
