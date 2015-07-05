package com.jscraper.scraper;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jscraper.constants.HTMLConstants;
import com.jscraper.db.mbeans.InputAction;
import com.jscraper.db.mbeans.InputConfig;
import com.jscraper.exceptions.WebScrapingException;
import com.jscraper.util.InputsGenerator;

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
				webElement.sendKeys(inputAction.getInputConfig().getValue());
			}
		}else{
			if(inputAction.getInputConfig().getRandomValue()){
			}else{
				webElements.get(inputAction.getIndex()).sendKeys(inputAction.getInputConfig().getValue());
			}
		}
	}
	
	public String getInputType(WebElement webElement,InputConfig inputConfig){
		String tagType = webElement.getTagName();
		String type;
		if(tagType.equalsIgnoreCase(HTMLConstants.INPUT_TAG)){
			type = webElement.getAttribute(HTMLConstants.TYPE);
			if(type.equalsIgnoreCase(HTMLConstants.TEXT_BOX)){
				
			}else if(type.equalsIgnoreCase(HTMLConstants.PASSWORD)){
				return InputsGenerator.generatePassword(inputConfig);
			}else if(type.equalsIgnoreCase(HTMLConstants.EMAIL)){
				return InputsGenerator.generateEmail(inputConfig);
			}else if(type.equalsIgnoreCase(HTMLConstants.NUMBER)){
				
			}else if(type.equalsIgnoreCase(HTMLConstants.RADIO_BTN)){
				
			}else if(type.equalsIgnoreCase(HTMLConstants.CHECK_BOX)){
				
			}
		}else if(tagType.equalsIgnoreCase(HTMLConstants.TEXT_AREA)){
			
		}else if(tagType.equalsIgnoreCase(HTMLConstants.SELECT_TAG)){
			
		}
		return null;
	}
	
	public String getValueTextBox(WebElement webElement,InputConfig inputConfig){
		return null;
	}
}