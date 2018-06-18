package com.qa.quickstart.demosite;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Ignore;



public class TheDemoSite {
	ChromeDriver driver; 
	
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	@Ignore
	public void navigateToPage() {
		driver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/";
		driver.navigate().to(url);
		assertEquals("http://thedemosite.co.uk/", driver.getCurrentUrl());
	}
	
	@Test
	public void createUser() {
		driver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/";
		driver.navigate().to(url);
		driver.findElement(By.linkText("3. Add a User")).click();
		assertEquals("http://thedemosite.co.uk/addauser.php", driver.getCurrentUrl());
	}
	
	@After
	public void after() {
		driver.close();
	}
}