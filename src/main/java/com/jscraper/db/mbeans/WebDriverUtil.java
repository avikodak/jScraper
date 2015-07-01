package com.jscraper.db.mbeans;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jscraper.constants.WebDriverType;
import com.jscraper.exceptions.WebScraperDriverException;
import com.jscraper.util.ValidationUtil;

public class WebDriverUtil {

	private static void setExeLocation(DesiredCapabilities desiredCapabilities,WebDriverDetails webDriverDetails) throws WebDriverException{
		if(ValidationUtil.isNull(webDriverDetails)){
			return;
		}
		String location = webDriverDetails.getExeLocation().getLocation();
		if(ValidationUtil.isEmpty(location)){
			throw new WebDriverException("Web driver exe location is empty.If not required set location details to null");
		}
		if(webDriverDetails.getType().equalsIgnoreCase(WebDriverType.PHANTOM)){
			desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, location);
		}else if(webDriverDetails.getType().equalsIgnoreCase(WebDriverType.GOOGLE_CHROME)){
			desiredCapabilities.setCapability(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, location);
		}else{
			throw new WebDriverException("We only allow users to set phantom and chrome driver exe locations");
		}
	}

	private static DesiredCapabilities getDesiredCapabilities(WebDriverDetails webDriverDetails){
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		if(ValidationUtil.isNotNull(webDriverDetails.getExeLocation())){
			setExeLocation(desiredCapabilities, webDriverDetails);
		}
		if(ValidationUtil.isNotNull(webDriverDetails.getEnableJS())){
			desiredCapabilities.setJavascriptEnabled(webDriverDetails.getEnableJS());
		}
		if(ValidationUtil.isNotEmpty(webDriverDetails.getBrowserName())){
			desiredCapabilities.setBrowserName(webDriverDetails.getBrowserName());
		}
		if(ValidationUtil.isNotEmpty(webDriverDetails.getVersion())){
			desiredCapabilities.setVersion(webDriverDetails.getVersion());
		}
		return desiredCapabilities;
	}

	private static WebDriver getFireFoxDriver(WebDriverDetails webDriverDetails,DesiredCapabilities desiredCapabilities){
		FirefoxDriver driver = new FirefoxDriver(desiredCapabilities);
		return driver;
	}
	
	private static WebDriver getChromeDriver(WebDriverDetails webDriverDetails,DesiredCapabilities desiredCapabilities){
		ChromeDriver chromeDriver = new ChromeDriver();
		BrowsingLocationDetails proxyLocation = webDriverDetails.getProxyLocation();
		chromeDriver.setLocation(new Location(proxyLocation.getLatitude(), proxyLocation.getLongitude(), proxyLocation.getAltitude()));
		return chromeDriver;
	}
	
	private static WebDriver getHtmlUnitDriver(WebDriverDetails webDriverDetails,DesiredCapabilities desiredCapabilities){
		HtmlUnitDriver htmlUnitDriver = new HtmlUnitDriver();
		return htmlUnitDriver;
	}

	private static WebDriver getPhantomJSDriver(WebDriverDetails webDriverDetails,DesiredCapabilities desiredCapabilities){
		PhantomJSDriver phantomJSDriver = new PhantomJSDriver(desiredCapabilities);
		return phantomJSDriver;
	}
	
	public static WebDriver getWebDriver(WebDriverDetails webDriverDetails) throws WebScraperDriverException{
		DesiredCapabilities desiredCapabilities = getDesiredCapabilities(webDriverDetails);
		if(webDriverDetails.getType().equalsIgnoreCase(WebDriverType.FIREFOX)){
			return getFireFoxDriver(webDriverDetails, desiredCapabilities);
		}else if(webDriverDetails.getType().equalsIgnoreCase(WebDriverType.PHANTOM)){
			return getPhantomJSDriver(webDriverDetails, desiredCapabilities);
		}else if(webDriverDetails.getType().equalsIgnoreCase(WebDriverType.HTML_UNIT)){
			return getHtmlUnitDriver(webDriverDetails, desiredCapabilities);
		}else if(webDriverDetails.getType().equalsIgnoreCase(WebDriverType.GOOGLE_CHROME)){
			return getChromeDriver(webDriverDetails, desiredCapabilities);
		}
		throw new WebScraperDriverException("We only support firefox,phantom,chrome,htmlunit webdrivers");
	}
}	
