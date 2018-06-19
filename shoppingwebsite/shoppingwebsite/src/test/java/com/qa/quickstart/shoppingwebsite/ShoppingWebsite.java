package com.qa.quickstart.shoppingwebsite;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Ignore;

public class ShoppingWebsite {
	ChromeDriver driver;
	
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void navigateToPage() {
		driver.manage().window().maximize();
		String url = "http://automationpractice.com/index.php";
		driver.navigate().to(url);
		assertEquals("http://automationpractice.com/index.php", driver.getCurrentUrl());
	}
	
	@After
	public void after() {
		driver.close();
	}
}
