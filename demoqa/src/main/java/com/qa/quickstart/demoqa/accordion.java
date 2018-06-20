package com.qa.quickstart.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class accordion {
	WebDriver driver;
	
	public accordion(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id = "ui-id-4")
	private WebElement item1;
	@FindBy(id = "ui-id-6")
	private WebElement item2;
	@FindBy(id = "ui-id-8")
	private WebElement item3;
	@FindBy(id = "ui-id-10")
	private WebElement item4;
	
	public void selectIndividual() {
		Actions act = new Actions(driver);
		act.moveToElement(item1).click().moveToElement(item2).click().moveToElement(item3).click().moveToElement(item4).click().perform();
	}
}
