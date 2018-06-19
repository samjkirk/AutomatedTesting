package com.qa.quickstart.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class selectable {
	WebDriver driver;
	
	public selectable(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[1]")
	private WebElement item1;
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[2]")
	private WebElement item2;
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[3]")
	private WebElement item3;
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[4]")
	private WebElement item4;
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[5]")
	private WebElement item5;
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[6]")
	private WebElement item6;
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[7]")
	private WebElement item7;

	public void selectIndividual() {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(item1).click().
				moveToElement(item2).click().
				moveToElement(item3).click().
				moveToElement(item4).click().
				moveToElement(item5).click().
				moveToElement(item6).click().
				moveToElement(item7).click().perform();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
