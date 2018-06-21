package com.qa.quickstart.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class tabs {
	WebDriver driver;
	
	public tabs(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "#ui-id-1")
	private WebElement tab1;
	@FindBy(css = "#ui-id-2")
	private WebElement tab2;
	@FindBy(css = "#ui-id-3")
	private WebElement tab3;
	
	public void cycleTabs() {
		try {
			tab1.click();
			Thread.sleep(1000);
			tab2.click();
			Thread.sleep(1000);
			tab3.click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebElement getActiveTab() {
		return driver.findElement(By.xpath("//*[@id=\"tabs-3\"]"));
	}
}
