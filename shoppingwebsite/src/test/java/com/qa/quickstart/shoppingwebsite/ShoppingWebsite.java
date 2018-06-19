package com.qa.quickstart.shoppingwebsite;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
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

public class ShoppingWebsite {
	ChromeDriver driver;
	static ExtentReports shoppingsiteREPORT;
	String search = "Printed Dress";
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver_win32\\chromedriver.exe");
		shoppingsiteREPORT = new ExtentReports ("C:\\Users\\Admin\\Documents\\AutomatedTestingExercises\\reports\\shoppingsiteREPORT.html", true);
	}
	
	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://automationpractice.com/index.php";
		driver.navigate().to(url);	
	}
	
	@Test
	public void searchForItem() {
		ExtentTest test1 = shoppingsiteREPORT.startTest("Attempt to search for 'Dress'");
		test1.log(LogStatus.INFO, "Browser started");
		WebElement searchbar = driver.findElement(By.id("search_query_top"));
		List<String> productNames = new ArrayList<String>();
		
		searchbar.clear();
		searchbar.click();
		searchbar.sendKeys(search);
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		test1.log(LogStatus.INFO, "Successfully searched for 'Dress'");
		
		WebElement grid = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul"));
		List<WebElement> products = grid.findElements(By.className("product-name"));
		for (WebElement we : products) {
			productNames.add(we.getText());
		} 
		
		try {
		assertTrue(productNames.contains(search));
		test1.log(LogStatus.PASS, "Search contained items conataining 'Dress'");
		} 
		catch (AssertionError e) {
			test1.log(LogStatus.FAIL, "Search failed");
			fail();
		} 
		finally {
			test1.log(LogStatus.INFO, "Current URL:" + driver.getCurrentUrl());
		}
	}
	
	@After
	public void after() {
		driver.close();
		shoppingsiteREPORT.flush();
	}
}
