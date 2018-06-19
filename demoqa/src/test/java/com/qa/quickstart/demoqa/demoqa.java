package com.qa.quickstart.demoqa;

import static org.junit.Assert.*;
//import java.util.ArrayList;
//import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;

public class demoqa {
	ChromeDriver driver;
	static ExtentReports demoqaREPORT;
	home demoqaHomePage = PageFactory.initElements(driver, home.class);
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver_win32\\chromedriver.exe");
		demoqaREPORT = new ExtentReports ("C:\\Users\\Admin\\Documents\\AutomatedTestingExercises\\reports\\demoqaREPORT.html", true);
	}
	
	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://demoqa.com/";
		driver.navigate().to(url);	
	}
	
	@Test
	public void droppableTest() {
		ExtentTest test1 = demoqaREPORT.startTest("Testing the functionality of 'Droppable'");
		test1.log(LogStatus.INFO, "Browser started");
		
		droppable droppablePage = PageFactory.initElements(driver, droppable.class);
		demoqaHomePage.clickDroppable();
		droppablePage.dragAndDropIt();
		
		try {
			assertEquals("Dropped!", driver.findElement(By.xpath("//*[@id=\"droppableview\"]/p")).getText());
			test1.log(LogStatus.PASS, "Drop successful!");
		} catch (AssertionError e) {
			test1.log(LogStatus.FAIL, "Drop unsuccessful!");
			fail();
		} finally {
			test1.log(LogStatus.INFO, "Current URL:" + driver.getCurrentUrl());
		}
	}
	
	@Test
	public void selectableTest() {
		ExtentTest test2 = demoqaREPORT.startTest("Testing the functionality of 'Droppable'");
		test2.log(LogStatus.INFO, "Browser started");
		
		selectable selectablePage = PageFactory.initElements(driver, selectable.class);
		demoqaHomePage.clickSelectable();
		selectablePage.selectIndividual();
		
		try {
			assertEquals("Dropped!", driver.findElement(By.xpath("//*[@id=\"droppableview\"]/p")).getText());
			test2.log(LogStatus.PASS, "Drop successful!");
		} catch (AssertionError e) {
			test2.log(LogStatus.FAIL, "Drop unsuccessful!");
			fail();
		} finally {
			test2.log(LogStatus.INFO, "Current URL:" + driver.getCurrentUrl());
		}
	}
	
	@After
	public void after() {
		driver.close();
		
		demoqaREPORT.flush();
	}
}

