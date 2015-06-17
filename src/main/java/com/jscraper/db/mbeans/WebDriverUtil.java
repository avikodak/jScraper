package com.jscraper.db.mbeans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jscraper.constants.WebDriverType;
import com.jscraper.utils.PropertyReader;

public class WebDriverUtil {

	public static WebDriver getWebDriver(){
		return null;
	}

	private static WebDriver getPhantomDriver(){
		DesiredCapabilities dCapabilities = new DesiredCapabilities();
		dCapabilities.setJavascriptEnabled(true);
		dCapabilities.setCapability(
				PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				PropertyReader.getPropertyValue("phantom.exe.location")
				+ "/phantomjs.exe");
		return new PhantomJSDriver(dCapabilities);
	}

	private static WebDriver getFirefoxDriver(){
		return new FirefoxDriver();
	}
	
	private static WebDriver getChromeDriver(){
		return new ChromeDriver();
	}

	private static WebDriver getHtmlUnitDriver(){
		return new HtmlUnitDriver();
	}
	
	public static WebDriver getWebDriver(String type){
		if(type.equalsIgnoreCase(WebDriverType.FIREFOX)){
			return getFirefoxDriver();
		}else if(type.equalsIgnoreCase(WebDriverType.PHANTOM)){
			return getPhantomDriver();
		}else if(type.equalsIgnoreCase(WebDriverType.HTML_UNIT)){
			return getHtmlUnitDriver();
		}else if(type.equalsIgnoreCase(WebDriverType.GOOGLE_CHROME)){
			return getChromeDriver();
		}
		return null;
	}
}	
