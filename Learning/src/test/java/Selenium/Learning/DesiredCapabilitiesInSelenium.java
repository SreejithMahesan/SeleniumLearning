package Selenium.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DesiredCapabilitiesInSelenium {
WebDriver driver;
	
	@BeforeTest
	public void BeforeTest()
	{
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		//cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void DesiredCapMethods()
	{
		
//		getBrowserName()
//		setBrowserName()
//		getVersion()
//		setVersion()
//		getPlatform()
//		setPlatform()
//		getCapability()
//		setCapapbility()
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
	
}
