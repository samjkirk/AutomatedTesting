package com.qa.quickstart.demoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class home {
	
	@FindBy(xpath = "//*[@id=\"menu-item-141\"]/a") 
	private WebElement droppableButton;

	public void clickDroppable() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		droppableButton.click();
	}
}
