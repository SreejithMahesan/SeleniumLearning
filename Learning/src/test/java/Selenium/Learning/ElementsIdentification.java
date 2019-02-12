package Selenium.Learning;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ElementsIdentification {
	WebDriver driver;
	
	@BeforeTest
	public void BeforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void MultipleAttributesWithCssSelector()
	{
		
		WebElement inputElement01 = driver.findElement(By.cssSelector("form input#email"));
		WebElement inputElement02 = driver.findElement(By.cssSelector("input.emai"));
		WebElement inputElement03 = driver.findElement(By.cssSelector("input[type='submit'][value='Subscribed']"));
		
		WebElement startingwith = driver.findElement(By.cssSelector("input[id^='email']"));
		WebElement endingwith = driver.findElement(By.cssSelector("input[id$='email']"));
		WebElement containing = driver.findElement(By.cssSelector("input[id*='email']"));
		
		
	}
	
	@Test
	public void MultipleAttributeswithXPath()
	{
		//Finds the third input tag in the page
		WebElement thirdinput = driver.findElement(By.xpath("//input[3]"));
		
		//Finding element with attributes using xpath
		WebElement logo = driver.findElement(By.xpath("img[@name='logo'"));
		
		WebElement stratswith = driver.findElement(By.xpath("input[starts-with(@id,'input')]"));
		WebElement endsswith = driver.findElement(By.xpath("input[ends-with(@id,'input')]"));
		WebElement contains = driver.findElement(By.xpath("input[contains(@id,'input')]"));
		
		WebElement andControl = driver.findElement(By.xpath("input[@type='submit' AND @name='Login']"))	;
		WebElement orControl = driver.findElement(By.xpath("input[@type='submit' OR @name='Login']"))	;
	}
	
	public void DropdownTests()
	{
		WebElement dropdownctrl = driver.findElement(By.xpath("drp"));
		/*if(dropdownctrl.IsMultiple)
		{
			dropdownctrl.selectByVisisbletext("String text");
			dropdownctrl.selectByValue("String value");
			dropdownctrl.selectByIndex(1);
			
			dropdownctrl.deselectByVisisbletext("String text");
			dropdownctrl.deselectByValue("String value");
			dropdownctrl.deselectByIndex(1);
			
			dropdownctrl.deselectAll();
			
		}*/
	}
	
	public void LinksTests()
	{
		WebElement link01 = driver.findElement(By.linkText("linktext"));
		link01 =driver.findElement(By.partialLinkText("partialtext"));
		
		//Use xpath or css selector for exact control locating when multiple links are present with same text
		
		
		List<WebElement> allLinks= driver.findElements(By.tagName("a"));
		for (WebElement link : allLinks) {
			if(link.getText()== "Hello")
			{
				link.click();
				break;
			}	
			
		}
		
		
	}
	
	
	
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
	

}
