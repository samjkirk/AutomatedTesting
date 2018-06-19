package com.qa.quickstart.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class droppable {
	WebDriver driver;
	
	public droppable(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"draggableview\"]")
	private WebElement draggableBox;
	@FindBy(xpath = "//*[@id=\"droppableview\"]")
	private WebElement droppableBox;
	
	public void dragAndDropIt() {
		Actions act = new Actions(driver);
		act.moveToElement(draggableBox).clickAndHold().moveToElement(droppableBox).release().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
