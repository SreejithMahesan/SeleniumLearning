package Selenium.Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Tables {
	WebDriver driver;
	@BeforeTest
	public void BeforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	public void TableAccess()
	{
		WebElement table01 = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
		String innerText = table01.getText();
		
		WebElement nestedTable = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
		
	}

}
