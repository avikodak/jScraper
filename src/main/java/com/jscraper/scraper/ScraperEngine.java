package com.jscraper.scraper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jscraper.constants.ElementSelectorType;
import com.jscraper.db.mbeans.ClickAction;
import com.jscraper.db.mbeans.DoubleClickAction;
import com.jscraper.db.mbeans.ElementSelector;
import com.jscraper.db.mbeans.RedirectionAction;
import com.jscraper.exceptions.WebScrapingException;
import com.jscraper.util.ValidationUtil;

public class ScraperEngine {

	public static void click(WebDriver webdriver,ClickAction clickAction){

	}

	public static void click(WebElement parentWebElement,ClickAction clickAction){
		parentWebElement.findElement(By.className(""));
	}

	public static void doubleClick(DoubleClickAction doubleClickAction){

	}

	public static void redirection(RedirectionAction redirectionAction){

	}

	public static void iframeSwitch(){

	}
	
	private WebElement getWebElement(WebElement parentElement,ElementSelector elementSelector) throws WebScrapingException{
		List<WebElement> webElements = getWebElements(parentElement, elementSelector);
		if(webElements == null || webElements.size() < elementSelector.getIndex()){

		}
		return webElements.get(elementSelector.getIndex());
	}

	private WebElement getWebElement(WebDriver webDriver,ElementSelector elementSelector) throws WebScrapingException{
		List<WebElement> webElements = getWebElements(webDriver, elementSelector);
		if(webElements == null || webElements.size() < elementSelector.getIndex()){

		}
		return webElements.get(elementSelector.getIndex());
	}

	private static List<WebElement> getWebElements(WebElement parentElement,ElementSelector elementSelector) throws WebScrapingException{
		if(ValidationUtil.isNull(parentElement)){
			
		}
		if(ValidationUtil.isNull(elementSelector)){ 
			
		}
		if(ValidationUtil.isEmpty(elementSelector.getType())){
			
		}
		if(ValidationUtil.isEmpty(elementSelector.getIdentifier())){
			
		}
		String type = elementSelector.getType(); 
		if(ElementSelectorType.CLASS.equalsIgnoreCase(type)){
			return parentElement.findElements(By.className(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.CSS.equalsIgnoreCase(type)){
			return parentElement.findElements(By.cssSelector(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.ID.equalsIgnoreCase(type)){
			return parentElement.findElements(By.id(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.LINK_TEXT.equalsIgnoreCase(type)){
			return parentElement.findElements(By.linkText(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.NAME.equalsIgnoreCase(type)){
			return parentElement.findElements(By.name(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.PARTIAL_LINK_TEXT.equalsIgnoreCase(type)){
			return parentElement.findElements(By.partialLinkText(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.TAGNAME.equalsIgnoreCase(type)){
			return parentElement.findElements(By.tagName(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.XPATH.equalsIgnoreCase(type)){
			return parentElement.findElements(By.xpath(elementSelector.getIdentifier()));
		}
		throw new WebScrapingException("");
	}

	private static List<WebElement> getWebElements(WebDriver webDriver,ElementSelector elementSelector){
		return null;
	}
}
