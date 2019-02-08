package Selenium.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotClassSelenium {
//Simulate Keyboard and Mouse Events
	
	@Test
	public void RoboClassTest() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Robot robot = null;
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
		
		try
		{
			robot = new Robot();
		}
		catch(AWTException e)
		{
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		
		driver.quit();
	}
	
}
