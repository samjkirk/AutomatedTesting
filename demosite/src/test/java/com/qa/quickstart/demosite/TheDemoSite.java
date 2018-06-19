package com.qa.quickstart.demosite;

import static org.junit.Assert.*;
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

public class TheDemoSite {
	ChromeDriver driver;
	static ExtentReports demositeREPORT;
	String username = "skUser3";
	String password = "password";
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver_win32\\chromedriver.exe");
		demositeREPORT = new ExtentReports ("C:\\Users\\Admin\\Documents\\AutomatedTestingExercises\\reports\\demositeREPORT.html", true);
	}
	
	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/";
		driver.navigate().to(url);	
	}
	
	@Test
	public void createUser() {
		ExtentTest test1 = demositeREPORT.startTest("Attempt create user");
		test1.log(LogStatus.INFO, "Browser started");
		WebElement checkElement;
		try {
			driver.findElement(By.linkText("3. Add a User")).click();
			driver.findElement(By.name("username")).click();
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).click();
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("FormsButton2")).click();
			test1.log(LogStatus.PASS, "Succesfully created a new user");
			driver.findElement(By.linkText("4. Login")).click();
			driver.findElement(By.name("username")).click();
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).click();
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("FormsButton2")).click();
			checkElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
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
	
	@After
	public void after() {
		driver.close();
		demositeREPORT.flush();
	}
}