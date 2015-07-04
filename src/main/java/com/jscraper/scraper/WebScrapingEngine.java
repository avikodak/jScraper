package com.jscraper.scraper;

import org.openqa.selenium.WebDriver;

import com.jscraper.db.mbeans.BaseAction;
import com.jscraper.db.mbeans.ClickAction;
import com.jscraper.db.mbeans.IFrameSwitchAction;
import com.jscraper.db.mbeans.InputAction;
import com.jscraper.db.mbeans.JobConfig;
import com.jscraper.db.mbeans.NavigationAction;
import com.jscraper.db.mbeans.WebDriverUtil;
import com.jscraper.exceptions.WebScrapingException;

public class WebScrapingEngine {

	private WebDriver webDriver = null;
	private MouseEngine mouseEngine = null;
	private NavigationEngine navigationEngine = null;
	private IFrameEngine iFrameEngine = null;
	private KeyboardEngine keyboardEngine = null;
	private JobConfig jobConfig;
	
	public WebScrapingEngine(JobConfig jobConfig) throws Exception{
		super();
		this.webDriver = WebDriverUtil.getWebDriver(jobConfig.getWebDriverDetails());
		this.jobConfig = jobConfig;
		this.mouseEngine = new MouseEngine(webDriver);
		this.navigationEngine = new NavigationEngine(webDriver);
		this.iFrameEngine = new IFrameEngine(webDriver);
		this.keyboardEngine = new KeyboardEngine(webDriver);
	}

	public void startScraping() throws WebScrapingException{
		webDriver.get(jobConfig.getBaseUrl());
		for (BaseAction baseAction : jobConfig.getActionsList()) {
			if(ClickAction.class.isInstance(baseAction)){
				mouseEngine.click((ClickAction)baseAction);
			} else if(NavigationAction.class.isInstance(baseAction)){
				navigationEngine.navigation((NavigationAction)baseAction);
			} else if(IFrameSwitchAction.class.isInstance(baseAction)){
				iFrameEngine.iframeSwitch((IFrameSwitchAction)baseAction);
			} else if(InputAction.class.isInstance(baseAction)){
				keyboardEngine.insertIntoInput((InputAction)baseAction);
			}
		}
	}
}
