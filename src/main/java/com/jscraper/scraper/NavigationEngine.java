package com.jscraper.scraper;

import org.openqa.selenium.WebDriver;

import com.jscraper.constants.NavigationType;
import com.jscraper.db.mbeans.NavigationAction;
import com.jscraper.exceptions.WebScrapingException;
import com.jscraper.util.ValidationUtil;

public class NavigationEngine {

	private WebDriver webDriver = null;

	public NavigationEngine(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public void navigation(NavigationAction navigationAction) throws WebScrapingException {
		if (navigationAction.getType().equalsIgnoreCase(NavigationType.BACK)) {
			webDriver.navigate().back();
		} else if (navigationAction.getType().equalsIgnoreCase(NavigationType.FORWARD)) {
			webDriver.navigate().forward();
		} else if (navigationAction.getType().equalsIgnoreCase(NavigationType.REDIRECTION)) {
			if (ValidationUtil.isEmpty(navigationAction.getUrl())) {
				throw new WebScrapingException("Redirect url cannot be empty");
			}
			webDriver.navigate().to(navigationAction.getUrl());
		} else if (navigationAction.getType().equalsIgnoreCase(NavigationType.REFRESH)) {
			webDriver.navigate().refresh();
		}
		throw new WebScrapingException("Invalid navigation type");
	}
}
