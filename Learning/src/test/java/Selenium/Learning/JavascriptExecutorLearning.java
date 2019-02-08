package Selenium.Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Object;

public class JavascriptExecutorLearning {

	
	public void JavaScriptTests()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
		WebElement webElement=driver.findElement(By.xpath("someprop"));
		
		js.executeAsyncScript("arguments[0].click();",webElement); 
		js.executeScript("arguments[0].click();",webElement);  
		
		driver.quit();
		
	}
}
