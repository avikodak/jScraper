package com.jscraper.db.mbeans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jscraper.constants.WebDriverType;

public class WebDriverUtil {
	
	public static WebDriver getWebDriver(){
		return null;
	}
		
	public static WebDriver getWebDriver(String type){
		if(type.equalsIgnoreCase(WebDriverType.FIREFOX)){
			return new FirefoxDriver();
		}else if(type.equalsIgnoreCase(WebDriverType.PHANTOM)){
			
		}else if(type.equalsIgnoreCase(WebDriverType.HTML_UNIT)){
			
		}else if(type.equalsIgnoreCase(WebDriverType.GOOGLE_CHROME)){
			return new ChromeDriver();
		}
		return null;
	}
}	
