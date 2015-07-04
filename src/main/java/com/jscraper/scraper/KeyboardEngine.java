package com.jscraper.scraper;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.jscraper.db.mbeans.InputAction;
import com.jscraper.exceptions.WebScrapingException;

public class KeyboardEngine {
	
	private WebDriver webDriver = null;
	private Actions actions = null;

	public KeyboardEngine(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
		this.actions = new Actions(webDriver);
	}
	
	public void insertIntoInput(InputAction inputAction) throws WebScrapingException{
		List<WebElement> webElements = ElementExtractionEngine.getWebElements(webDriver,inputAction.getElementSelector());
		actions.moveToElement(webElements.get(0)).click().build().perform();//.click().sendKeys(webElements.get(0), inputAction.getValue()).build();
		actions.moveByOffset(100, 100).perform();
	}
}
