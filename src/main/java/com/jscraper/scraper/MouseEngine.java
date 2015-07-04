package com.jscraper.scraper;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.jscraper.db.mbeans.ClickAction;
import com.jscraper.exceptions.WebScrapingException;

public class MouseEngine {

	private WebDriver webDriver = null; 
	private Actions actions = null;
	
	public MouseEngine(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
		actions = new Actions(webDriver);
	}

	private void click(ClickAction clickAction, List<WebElement> webElements) throws WebScrapingException {
		if (clickAction.getClickOnEachElement()) {
			for (WebElement webElement : webElements) {
				if (clickAction.getDoubleClick()) {
					actions.doubleClick(webElement).perform();
				} else if (clickAction.getContextClick()) {
					actions.contextClick(webElement).perform();
				} else {
					actions.click(webElement).perform();
				}
			}
		} else {
			if (webElements == null || webElements.size() <= clickAction.getElementSelector().getIndex()) {
				throw new WebScrapingException("Invalid index. Array index exceeds size");
			}
			WebElement webElement = webElements.get(clickAction.getElementSelector().getIndex());
			if (clickAction.getDoubleClick()) {
				actions.doubleClick(webElement).perform();
			} else if (clickAction.getContextClick()) {
				actions.contextClick(webElement).perform();
			} else {
				actions.click(webElement).perform();
			}
		}
	}

	public void click(ClickAction clickAction) throws WebScrapingException {
		List<WebElement> webElements = ElementExtractionEngine.getWebElements(webDriver,clickAction.getElementSelector());
		click(clickAction, webElements);
	}

	public void click(WebElement parentWebElement, ClickAction clickAction) throws WebScrapingException {
		List<WebElement> webElements = ElementExtractionEngine.getWebElements(parentWebElement,clickAction.getElementSelector());
		click(clickAction, webElements);
	}
}
