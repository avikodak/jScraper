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
		JobConfig jobConfig = new JobConfig(WebDriverType.FIREFOX,"https://www.facebook.com");
		ClickAction clickAction = new ClickAction(new ElementSelector(ElementSelectorType.XPATH,".//input[@id='u_0_x']"));
		InputAction inputAction = new InputAction(new ElementSelector(ElementSelectorType.ID,"email"));
		inputAction.setValue("avikodak");
		jobConfig.getActionsList().add(inputAction);
		jobConfig.getActionsList().add(clickAction);
		WebScrapingEngine engine = new WebScrapingEngine(jobConfig);
		engine.startScraping();
	}

}
