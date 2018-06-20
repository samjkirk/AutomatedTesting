package com.qa.quickstart.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class datepicker {
	WebDriver driver;
	
	public datepicker(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(name = "selected_date")
	private WebElement selected_date;
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")
	private WebElement previous;
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[4]/a")
	private WebElement date;
	
	public void showCalender() {
		selected_date.click();
	}
	
	public void selectDate() {
		Actions act = new Actions(driver);
		try {
			Thread.sleep(2000);
			previous.click();
			Thread.sleep(2000);
			act.moveToElement(date).click().perform();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getDate() {
		try {
			Thread.sleep(2000);
			return selected_date.getAttribute("value");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
