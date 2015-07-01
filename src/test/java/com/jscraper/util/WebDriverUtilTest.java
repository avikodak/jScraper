package com.jscraper.util;

import org.openqa.selenium.WebDriver;

import com.jscraper.constants.WebDriverType;
import com.jscraper.db.mbeans.WebDriverDetails;
import com.jscraper.db.mbeans.WebDriverUtil;


public class WebDriverUtilTest {

	public static void main(String[] args) throws Exception{
		WebDriverDetails webDriverDetails = new WebDriverDetails();
		webDriverDetails.setType(WebDriverType.HTML_UNIT);
		WebDriver webDriver = WebDriverUtil.getWebDriver(webDriverDetails);
		webDriver.get("http://www.google.com");
		System.out.println(webDriver.getTitle());
		if(ValidationUtil.isNull(webDriver)){
			System.out.println("Test failed");
		}else{
			System.out.println("Test passed");
		}
		System.out.println("Hwllo");
	}

}
