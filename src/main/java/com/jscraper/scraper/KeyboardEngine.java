package com.jscraper.scraper;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jscraper.db.mbeans.InputAction;
import com.jscraper.exceptions.WebScrapingException;

public class KeyboardEngine {
	
	private WebDriver webDriver = null;
	//private Actions actions = null;

	public KeyboardEngine(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
		//this.actions = new Actions(webDriver);
	}
	
	public void insertIntoInput(InputAction inputAction) throws WebScrapingException{
		List<WebElement> webElements = ElementExtractionEngine.getWebElements(webDriver,inputAction.getElementSelector());
		if(webElements == null || webElements.size() == 0){
			
		}
		if(inputAction.getInputAllElements()){
			for (WebElement webElement : webElements) {
				webElement.sendKeys(inputAction.getValue());
			}
		}else{
			if(inputAction.getRandomValue()){
			}else{
				webElements.get(inputAction.getIndex()).sendKeys(inputAction.getValue());
			}
		}
	}
}