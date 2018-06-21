package com.qa.quickstart.demoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class home {
	WebDriver driver;
	
	public home(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id = "menu-item-141") 
	private WebElement droppableButton;
	@FindBy(id = "menu-item-142") 
	private WebElement selectableButton;
	@FindBy(id = "menu-item-144")
	private WebElement accordionButton;
	@FindBy(id = "menu-item-145")
	private WebElement autoCompleteButton;
	@FindBy(id = "menu-item-146")
	private WebElement datePickerButton;
	@FindBy(id = "menu-item-147")
	private WebElement menuButton;
	@FindBy(id = "menu-item-97")
	private WebElement sliderButton;
	@FindBy(id = "menu-item-98")
	private WebElement tabsButton;
	@FindBy(id = "menu-item-99")
	private WebElement tooltipButton;

	public void clickDroppable() {
		droppableButton.click();
	}
	
	public void clickSelectable() {
		selectableButton.click();
	}
	
	public void clickWidget(int i) {
		switch (i) {
			case 1:
				accordionButton.click();
				break;
			case 2:
				autoCompleteButton.click();
				break;
			case 3:
				datePickerButton.click();
				break;
			case 4:
				menuButton.click();
				break;
			case 5:
				sliderButton.click();
				break;
			case 6:
				tabsButton.click();
				break;
			case 7:
				tooltipButton.click();
				break;
		}
	}
}
