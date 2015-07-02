package com.jscraper.scraper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jscraper.constants.ElementSelectorType;
import com.jscraper.constants.NavigationType;
import com.jscraper.db.mbeans.ClickAction;
import com.jscraper.db.mbeans.ElementSelector;
import com.jscraper.db.mbeans.IFrameSwitchAction;
import com.jscraper.db.mbeans.NavigationAction;
import com.jscraper.exceptions.WebScrapingException;
import com.jscraper.util.ValidationUtil;

public class WebScrapingEngine {
	
	private static void click(ClickAction clickAction,List<WebElement> webElements) throws WebScrapingException {
		if(clickAction.getClickOnEachElement()){
			for (WebElement webElement : webElements) {
				if(clickAction.getDoubleClick()){
					webElement.click();
					webElement.click();
				}else{
					webElement.click();
				}
			}
		}else{
			if(webElements == null || webElements.size() <= clickAction.getElementSelector().getIndex()){
				throw new WebScrapingException("Invalid index. Array index exceeds size");
			}
			WebElement webElement = webElements.get(clickAction.getElementSelector().getIndex());
			if(clickAction.getDoubleClick()){
				webElement.click();
				webElement.click();
			}else{
				webElement.click();
			}
		}
	}
	
	public static void click(WebDriver webdriver,ClickAction clickAction) throws WebScrapingException{
		List<WebElement> webElements = getWebElements(webdriver, clickAction.getElementSelector());
		click(clickAction, webElements);
	}

	public static void click(WebElement parentWebElement,ClickAction clickAction) throws WebScrapingException{
		List<WebElement> webElements = getWebElements(parentWebElement, clickAction.getElementSelector());
		click(clickAction, webElements);
	}

	public static void navigation(WebDriver webDriver,NavigationAction navigationAction) throws WebScrapingException{
		if(navigationAction.getType().equalsIgnoreCase(NavigationType.BACK)){
			webDriver.navigate().back();
		}else if(navigationAction.getType().equalsIgnoreCase(NavigationType.FORWARD)){
			webDriver.navigate().forward();
		}else if(navigationAction.getType().equalsIgnoreCase(NavigationType.REDIRECTION)){
			if(ValidationUtil.isEmpty(navigationAction.getUrl())){
				throw new WebScrapingException("Redirect url cannot be empty");
			}
			webDriver.navigate().to(navigationAction.getUrl());
		}else if(navigationAction.getType().equalsIgnoreCase(NavigationType.REFRESH)){
			webDriver.navigate().refresh();
		}
		throw new WebScrapingException("Invalid navigation type");
	}
	
	public static void iframeSwitch(WebDriver webDriver,IFrameSwitchAction iFrameSwitchAction) throws WebScrapingException{
		if(ValidationUtil.isNotEmpty(iFrameSwitchAction.getIdOrName())){
			webDriver.switchTo().frame(iFrameSwitchAction.getIdOrName());
		}else if(ValidationUtil.isNotNull(iFrameSwitchAction.getIndex())){
			webDriver.switchTo().frame(iFrameSwitchAction.getIndex());
		}else if(ValidationUtil.isNotNull(iFrameSwitchAction.getElementSelector())){
			webDriver.switchTo().frame(getWebElement(webDriver, iFrameSwitchAction.getElementSelector()));
		}
		throw new WebScrapingException("Invalid selector for iframe switch");
	}
	
	@SuppressWarnings("unused")
	private WebElement getWebElement(WebElement parentElement,ElementSelector elementSelector) throws WebScrapingException{
		List<WebElement> webElements = getWebElements(parentElement, elementSelector);
		if(webElements == null || webElements.size() < elementSelector.getIndex()){
			throw new WebScrapingException("Contains invalid index");
		}
		return webElements.get(elementSelector.getIndex());
	}

	private static WebElement getWebElement(WebDriver webDriver,ElementSelector elementSelector) throws WebScrapingException{
		List<WebElement> webElements = getWebElements(webDriver, elementSelector);
		if(webElements == null || webElements.size() < elementSelector.getIndex()){
			throw new WebScrapingException("Contains invalid index");
		}
		return webElements.get(elementSelector.getIndex());
	}

	private static List<WebElement> getWebElements(WebElement parentElement,ElementSelector elementSelector) throws WebScrapingException{
		if(ValidationUtil.isNull(parentElement)){
			throw new WebScrapingException("Parent element cannot be null");
		}
		if(ValidationUtil.isNull(elementSelector)){ 
			throw new WebScrapingException("Element selector cannot be null");
		}
		if(ValidationUtil.isEmpty(elementSelector.getType())){
			throw new WebScrapingException("Element selector type cannot be null");
		}
		if(ValidationUtil.isEmpty(elementSelector.getIdentifier())){
			throw new WebScrapingException("Element selector identifier cannot be empty");
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
		throw new WebScrapingException("Invalid element selector type");
	}

	private static List<WebElement> getWebElements(WebDriver webDriver,ElementSelector elementSelector) throws WebScrapingException{
		if(ValidationUtil.isNull(elementSelector)){ 
			throw new WebScrapingException("Element selector cannot be null");
		}
		if(ValidationUtil.isEmpty(elementSelector.getType())){
			throw new WebScrapingException("Element selector type cannot be null");
		}
		if(ValidationUtil.isEmpty(elementSelector.getIdentifier())){
			throw new WebScrapingException("Element selector identifier cannot be empty");
		}
		String type = elementSelector.getType(); 
		if(ElementSelectorType.CLASS.equalsIgnoreCase(type)){
			return webDriver.findElements(By.className(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.CSS.equalsIgnoreCase(type)){
			return webDriver.findElements(By.cssSelector(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.ID.equalsIgnoreCase(type)){
			return webDriver.findElements(By.id(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.LINK_TEXT.equalsIgnoreCase(type)){
			return webDriver.findElements(By.linkText(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.NAME.equalsIgnoreCase(type)){
			return webDriver.findElements(By.name(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.PARTIAL_LINK_TEXT.equalsIgnoreCase(type)){
			return webDriver.findElements(By.partialLinkText(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.TAGNAME.equalsIgnoreCase(type)){
			return webDriver.findElements(By.tagName(elementSelector.getIdentifier()));
		}else if(ElementSelectorType.XPATH.equalsIgnoreCase(type)){
			return webDriver.findElements(By.xpath(elementSelector.getIdentifier()));
		}
		throw new WebScrapingException("Invalid element selector type");
	}
}
