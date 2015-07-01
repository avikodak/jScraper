package com.jscraper.exceptions;

public class WebScraperDriverException extends BaseScraperException{

	private static final long serialVersionUID = 1L;

	public WebScraperDriverException(String message) {
		super(message);
	}
	
	public WebScraperDriverException(Integer code) {
		super(code);
	}
	
	public WebScraperDriverException(String message, Integer code) {
		super(message, code);
	}
}
