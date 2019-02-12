package Selenium.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataApachePOI {
	public static WebDriver driver;	
	
	@BeforeClass
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority =0)
	public void writeToExcel() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\TestData\\ExcelData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//XSSFSheet sheet = workbook.getSheet("TestData");
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.createRow(1);
		Cell cell = row.createCell(1);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("Data written by Apache POI");
		FileOutputStream fos = new FileOutputStream("C:\\TestData\\ExcelData.xlsx");
		workbook.write(fos);
		fos.close();
		System.out.println("END of Data Writing");
		
		fis.close();
		
		
		
	}
	
	@Test(priority =1)
	public void readFromExcel() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\TestData\\ExcelData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//XSSFSheet sheet = workbook.getSheet("TestData");
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		System.out.println(cell.getStringCellValue());		
		System.out.println("END of Data Writing");
		
		fis.close();
			
		
	}
	
	
	@AfterClass
	public void Teardown()
	{
		driver.quit();
	}
}
