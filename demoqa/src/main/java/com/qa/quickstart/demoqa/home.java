package com.qa.quickstart.demoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class home {
	
	@FindBy(xpath = "//*[@id=\"menu-item-141\"]/a") 
	private WebElement droppableButton;
	@FindBy(xpath = "//*[@id=\"menu-item-142\"]/a") 
	private WebElement selectableButton;

	public void clickDroppable() {
		droppableButton.click();
	}
	
	public void clickSelectable() {
		selectableButton.click();
	}
}
