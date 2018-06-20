package com.qa.quickstart.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class autocomplete {
	WebDriver driver;
	
	public autocomplete(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id = "tagss")
	private WebElement searchbar;
	@FindBy(id = "ui-id-16")
	private WebElement result;
	
	public String search() throws InterruptedException {
		Actions act = new Actions(driver);
		searchbar.click();
		searchbar.sendKeys("a");
		Thread.sleep(3000);
		act.moveToElement(result).click().perform();
		return searchbar.getAttribute("value");
	}
}
