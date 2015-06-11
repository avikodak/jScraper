package com.jscraper.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException{
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		  System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");

		  WebDriver driver = new ChromeDriver();
		  driver.get("http://www.google.com/xhtml");
		  Thread.sleep(5000);  // Let the user actually see something!
		  WebElement searchBox = driver.findElement(By.name("q"));
		  searchBox.sendKeys("ChromeDriver");
		  searchBox.submit();
		  Thread.sleep(5000);  // Let the user actually see something!
		  driver.quit();
	}
}
