package com.jscraper.exceptions;

public class WebScrapingException extends BaseScraperException{
	
	private static final long serialVersionUID = 5869147232426229672L;
	
	public WebScrapingException(String message) {
		super(message);
	}
	
	public WebScrapingException(Integer code) {
		super(code);
	}
	
	public WebScrapingException(String message, Integer code) {
		super(message, code);
	}
}
