package com.jscraper.util;

import com.jscraper.constants.ElementSelectorType;
import com.jscraper.constants.WebDriverType;
import com.jscraper.db.mbeans.ClickAction;
import com.jscraper.db.mbeans.ElementSelector;
import com.jscraper.db.mbeans.InputAction;
import com.jscraper.db.mbeans.JobConfig;
import com.jscraper.scraper.WebScrapingEngine;

public class WebDriverUtilTest {

	public static void main(String[] args) throws Exception{
		//WebDriverDetails webDriverDetails = new WebDriverDetails(WebDriverType.GOOGLE_CHROME);
		//webDriverDetails.setExeLocation(new FileLocationDetails("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe"));
		//JobConfig jobConfig = new JobConfig(webDriverDetails,"https://www.facebook.com");
		JobConfig jobConfig = new JobConfig(WebDriverType.FIREFOX,"https://www.facebook.com");
		ClickAction clickAction = new ClickAction(new ElementSelector(ElementSelectorType.XPATH,".//input[@id='u_0_x']"));
		//ClickAction clickAction = new ClickAction(new ElementSelector(ElementSelectorType.ID, "email"));
		InputAction userInputAction = new InputAction(new ElementSelector(ElementSelectorType.ID,"email"));
		InputAction passwordInputAction = new InputAction(new ElementSelector(ElementSelectorType.ID,"pass"));
		userInputAction.setValue("sdsd");
		passwordInputAction.setValue("xxxxx");
		//jobConfig.getActionsList().add(clickAction);
		jobConfig.getActionsList().add(userInputAction);
		jobConfig.getActionsList().add(passwordInputAction);
		jobConfig.getActionsList().add(clickAction);
		WebScrapingEngine engine = new WebScrapingEngine(jobConfig);
		engine.startScraping();
	}

}
