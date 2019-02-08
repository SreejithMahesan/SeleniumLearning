package Selenium.Learning;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Screenshots {
	public WebDriver driver;
	
	@BeforeClass
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
				
		
	}
	
	
	@Test
	public void ScreenshotTest() throws Exception
	{
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		takeSnapShot(driver,new Object() {}.getClass().getEnclosingMethod().getName());
		
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws IOException
	{
		TakesScreenshot srcShot = ((TakesScreenshot)webdriver);
		File SrcFile = srcShot.getScreenshotAs(OutputType.FILE);
		String fileName =  "C:\\ScreenShots\\" + fileWithPath +".png";
		File DestFile = new File(fileName);
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	
	@AfterClass
	public void Teardown()
	{
		driver.quit();
	}
}
