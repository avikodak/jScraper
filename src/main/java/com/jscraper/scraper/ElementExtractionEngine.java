package com.jscraper.scraper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jscraper.constants.ElementSelectorType;
import com.jscraper.db.mbeans.ElementSelector;
import com.jscraper.exceptions.WebScrapingException;
import com.jscraper.util.ValidationUtil;

public class ElementExtractionEngine {

	public static WebElement getWebElement(WebElement parentElement,ElementSelector elementSelector) throws WebScrapingException {
		List<WebElement> webElements = getWebElements(parentElement,elementSelector);
		if (webElements == null || webElements.size() < elementSelector.getIndex()) {
			throw new WebScrapingException("Contains invalid index");
		}
		return webElements.get(elementSelector.getIndex());
	}

	public static WebElement getWebElement(WebDriver webDriver,ElementSelector elementSelector) throws WebScrapingException {
		List<WebElement> webElements = getWebElements(webDriver,elementSelector);
		if (webElements == null || webElements.size() < elementSelector.getIndex()) {
			throw new WebScrapingException("Contains invalid index");
		}
		return webElements.get(elementSelector.getIndex());
	}

	public static List<WebElement> getWebElements(WebElement parentElement,ElementSelector elementSelector) throws WebScrapingException {
		if (ValidationUtil.isNull(parentElement)) {
			throw new WebScrapingException("Parent element cannot be null");
		}
		if (ValidationUtil.isNull(elementSelector)) {
			throw new WebScrapingException("Element selector cannot be null");
		}
		if (ValidationUtil.isEmpty(elementSelector.getType())) {
			throw new WebScrapingException("Element selector type cannot be null");
		}
		if (ValidationUtil.isEmpty(elementSelector.getIdentifier())) {
			throw new WebScrapingException("Element selector identifier cannot be empty");
		}
		String type = elementSelector.getType();
		if (ElementSelectorType.CLASS.equalsIgnoreCase(type)) {
			return parentElement.findElements(By.className(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.CSS.equalsIgnoreCase(type)) {
			return parentElement.findElements(By.cssSelector(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.ID.equalsIgnoreCase(type)) {
			return parentElement.findElements(By.id(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.LINK_TEXT.equalsIgnoreCase(type)) {
			return parentElement.findElements(By.linkText(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.NAME.equalsIgnoreCase(type)) {
			return parentElement.findElements(By.name(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.PARTIAL_LINK_TEXT.equalsIgnoreCase(type)) {
			return parentElement.findElements(By.partialLinkText(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.TAGNAME.equalsIgnoreCase(type)) {
			return parentElement.findElements(By.tagName(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.XPATH.equalsIgnoreCase(type)) {
			return parentElement.findElements(By.xpath(elementSelector.getIdentifier()));
		}
		throw new WebScrapingException("Invalid element selector type");
	}

	public static List<WebElement> getWebElements(WebDriver webDriver,ElementSelector elementSelector) throws WebScrapingException {
		if (ValidationUtil.isNull(elementSelector)) {
			throw new WebScrapingException("Element selector cannot be null");
		}
		if (ValidationUtil.isEmpty(elementSelector.getType())) {
			throw new WebScrapingException("Element selector type cannot be null");
		}
		if (ValidationUtil.isEmpty(elementSelector.getIdentifier())) {
			throw new WebScrapingException("Element selector identifier cannot be empty");
		}
		String type = elementSelector.getType();
		if (ElementSelectorType.CLASS.equalsIgnoreCase(type)) {
			return webDriver.findElements(By.className(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.CSS.equalsIgnoreCase(type)) {
			return webDriver.findElements(By.cssSelector(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.ID.equalsIgnoreCase(type)) {
			return webDriver.findElements(By.id(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.LINK_TEXT.equalsIgnoreCase(type)) {
			return webDriver.findElements(By.linkText(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.NAME.equalsIgnoreCase(type)) {
			return webDriver.findElements(By.name(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.PARTIAL_LINK_TEXT.equalsIgnoreCase(type)) {
			return webDriver.findElements(By.partialLinkText(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.TAGNAME.equalsIgnoreCase(type)) {
			return webDriver.findElements(By.tagName(elementSelector.getIdentifier()));
		} else if (ElementSelectorType.XPATH.equalsIgnoreCase(type)) {
			return webDriver.findElements(By.xpath(elementSelector.getIdentifier()));
		}
		throw new WebScrapingException("Invalid element selector type");
	}
}
