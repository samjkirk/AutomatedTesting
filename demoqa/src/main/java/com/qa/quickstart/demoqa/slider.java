package com.qa.quickstart.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class slider {
	WebDriver driver;
	
	public slider(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "#slider-range-max > span")
	private WebElement slider;
	@FindBy(id = "amount1")
	private WebElement amount;
	
	public void slide() {
		Actions act = new Actions(driver);
		try {
			Thread.sleep(3000);
			act.moveToElement(slider).clickAndHold().moveByOffset(500, 0).release().perform();
			Thread.sleep(1000);
			act.moveToElement(slider).clickAndHold().moveByOffset(-250, 0).release().perform();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getAmount() {
		return amount.getAttribute("value");
	}
}
