package com.qa.quickstart.demoqa;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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

	public void select(Boolean multiple) {
		Actions act = new Actions(driver);
		if (!multiple) {
			try {
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
		} else {
			try {
				act.moveToElement(item1).clickAndHold().moveToElement(item7).release().perform();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<String> findCurrentlySelected() {
		List<String> itemText = new ArrayList<String>();
		WebElement box = driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/div"));
		List<WebElement> selectedElements = box.findElements(By.className("ui-selected"));
		for (WebElement we : selectedElements) {
			itemText.add(we.getText());
		}
		System.out.println(itemText);
		return itemText;
	}
	
}
