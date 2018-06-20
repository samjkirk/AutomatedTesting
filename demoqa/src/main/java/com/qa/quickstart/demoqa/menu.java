package com.qa.quickstart.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class menu {
	WebDriver driver;
	
	public menu(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "#navigate > ul > li:nth-child(1)")
	private WebElement item1;
	@FindBy(css = "#navigate > ul > li:nth-child(1) > a")
	private WebElement item1Link;
	
	public String testHover() {
		Actions act = new Actions(driver);
		try {
			Thread.sleep(3000);
			act.moveToElement(item1).perform();
			return item1.getCssValue("background-color");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void testLink() {
		try {
			Thread.sleep(3000);
			item1Link.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
