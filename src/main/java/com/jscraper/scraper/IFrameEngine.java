package com.jscraper.scraper;

import org.openqa.selenium.WebDriver;

import com.jscraper.db.mbeans.IFrameSwitchAction;
import com.jscraper.exceptions.WebScrapingException;
import com.jscraper.util.ValidationUtil;

public class IFrameEngine {

	private WebDriver webDriver = null;

	public IFrameEngine(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}
	
	public void iframeSwitch(IFrameSwitchAction iFrameSwitchAction) throws WebScrapingException {
		if (ValidationUtil.isNotEmpty(iFrameSwitchAction.getIdOrName())) {
			webDriver.switchTo().frame(iFrameSwitchAction.getIdOrName());
		} else if (ValidationUtil.isNotNull(iFrameSwitchAction.getIndex())) {
			webDriver.switchTo().frame(iFrameSwitchAction.getIndex());
		} else if (ValidationUtil.isNotNull(iFrameSwitchAction.getElementSelector())) {
			webDriver.switchTo().frame(ElementExtractionEngine.getWebElement(webDriver,iFrameSwitchAction.getElementSelector()));
		}
		throw new WebScrapingException("Invalid selector for iframe switch");
	}
}
