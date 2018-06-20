package com.qa.quickstart.demoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class home {
	WebDriver driver;
	
	public home(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"menu-item-141\"]/a") 
	private WebElement droppableButton;
	@FindBy(xpath = "//*[@id=\"menu-item-142\"]/a") 
	private WebElement selectableButton;
	@FindBy(xpath = "//*[@id=\"menu-item-144\"]/a")
	private WebElement accordionButton;
	@FindBy(xpath = "//*[@id=\"menu-item-145\"]/a")
	private WebElement autoCompleteButton;
	@FindBy(xpath = "//*[@id=\"menu-item-146\"]/a")
	private WebElement datePickerButton;
	@FindBy(xpath = "//*[@id=\"menu-item-147\"]/a")
	private WebElement menuButton;
	@FindBy(xpath = "//*[@id=\"menu-item-97\"]/a")
	private WebElement sliderButton;
	@FindBy(xpath = "//*[@id=\"menu-item-98\"]/a")
	private WebElement tabsButton;
	@FindBy(xpath = "//*[@id=\"menu-item-99\"]/a")
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
