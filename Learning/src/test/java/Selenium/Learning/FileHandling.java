package Selenium.Learning;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import junit.framework.Assert;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileHandling {
	
	WebDriver driver;
	File folder;
	
	@BeforeTest
	public void BeforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void uploadfile()
	{
		WebElement uploadfile = driver.findElement(By.id("someproperty"));
		uploadfile.sendKeys("filepath");
		driver.findElement(By.id("term")).click();
		driver.findElement(By.name("send")).click();
	}
	
	public void DownloadfileWget() throws Throwable
	{
		WebElement downloadbtn = driver.findElement(By.id("messenger-download"));
		String sourcelocation = downloadbtn.getAttribute("href");
		
		String wget_command = "cmd /c wget -P c: " + sourcelocation;
		
		Process exec;
		int exitVal;
		try {
			exec = Runtime.getRuntime().exec(wget_command);
			exitVal = exec.waitFor();
			System.out.println("Exit Value: " + exitVal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}	
		
	}
	
	public void DownloadFile() throws Exception
	{
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		
		//chrome
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap =  DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(cap);	
		
		driver.get("someurl");
		driver.findElement(By.linkText("someselector")).click();
		
		Thread.sleep(5000);
		
		//Folder not Empty
		File[] listOfFiles = folder.listFiles();
		//Assert.assertEquals(is(not(0)), listOfFiles.length);
		Assert.assertTrue(listOfFiles.length>0);
		
		//File not Empty
		for(File file : listOfFiles)
		{
			//Assert.assertEquals(is(not((long)0)), file.length());
			Assert.assertTrue(file.length()>0);
		}
	}
	
	
	public void DownloadwithAutoIt()
	{
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
		for(File file : folder.listFiles())
		{
			file.delete();
		}
		folder.delete();
	}

}
