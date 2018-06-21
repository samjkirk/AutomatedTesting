package com.qa.quickstart.demosite;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TheDemoSite {
	ChromeDriver driver;
	static ExtentReports demositeREPORT;
	FileInputStream file = null;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver_win32\\chromedriver.exe");
		demositeREPORT = new ExtentReports ("C:\\Users\\Admin\\Documents\\AutomatedTestingExercises\\reports\\demositeREPORT.html", true);
	}
	
	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(Constant.URL1);
		try {
			file = new FileInputStream (Constant.PATH + Constant.TEST_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createUserAndSignIn() {
		ExtentTest test1 = demositeREPORT.startTest("Attempt create user");
		test1.log(LogStatus.INFO, "Browser started");
		WebElement checkElement;
		
		XSSFWorkbook workbook = null;
		
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		XSSFCell username = sheet.getRow(1).getCell(0);
		XSSFCell password = sheet.getRow(1).getCell(1);
		
		
		driver.findElement(By.linkText("3. Add a User")).click(); 
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys(username.getStringCellValue());
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys(password.getStringCellValue());
		driver.findElement(By.name("FormsButton2")).click();
		test1.log(LogStatus.PASS, "Succesfully created a new user");
		driver.findElement(By.linkText("4. Login")).click();
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys(username.getStringCellValue());
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys(password.getStringCellValue());
		driver.findElement(By.name("FormsButton2")).click();
		checkElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		
		try {
			assertEquals("**Successful Login**", checkElement.getText());
			test1.log(LogStatus.PASS, "Succesfully logged in");
		}
		catch (AssertionError e) {
			test1.log(LogStatus.FAIL, "Unable to create new user and log in");
			fail();
		}
		finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			demositeREPORT.endTest(test1);
		}
	}
	
	@Test
	public void createMultipleUsersAndSignIn() {
		ExtentTest test2 = demositeREPORT.startTest("Testing the creation and sign in of multiple users");
		test2.log(LogStatus.INFO, "Browser started");
		
		DataFormatter formatter  = new DataFormatter();
		
		XSSFWorkbook workbook = null;
		
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		int i = 1;
		
		try {
			while (sheet.getRow(i).getCell(0).getStringCellValue() != null) {
			XSSFCell result = sheet.getRow(i).getCell(2);
			String username = formatter.formatCellValue(sheet.getRow(i).getCell(0));
			String password = formatter.formatCellValue(sheet.getRow(i).getCell(1));
			
			driver.findElement(By.linkText("3. Add a User")).click();
			driver.findElement(By.name("username")).click();
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).click();
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("FormsButton2")).click();
			test2.log(LogStatus.PASS, "Succesfully created a new user: " + username);
			driver.findElement(By.linkText("4. Login")).click();
			driver.findElement(By.name("username")).click();
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).click();
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("FormsButton2")).click();
			WebElement checkElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
			String resultText = checkElement.getText();
			if (result == null)
			{
			    result = sheet.getRow(i).createCell(2);
			}
			result.setCellValue(resultText);
			try {
				file.close();
				FileOutputStream outFile = new FileOutputStream(new File(Constant.PATH + Constant.TEST_FILE));
				workbook.write(outFile);
				outFile.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			i++;
			}
		} catch (NullPointerException n) {
			System.out.print("Reached end of file...");
		}
		
		try {
			assertEquals("**Successful Login**", sheet.getRow(5).getCell(2).getStringCellValue());
			test2.log(LogStatus.PASS, "Result written to file");
		} catch (AssertionError e) {
			test2.log(LogStatus.FAIL, "Failed to write result to file");
			fail();
		} finally {
			test2.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			driver.quit();
		}
	}
	
	@After
	public void after() {
		driver.quit();
		demositeREPORT.flush();
	}
}