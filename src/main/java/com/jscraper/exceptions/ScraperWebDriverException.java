package com.jscraper.exceptions;

public class ScraperWebDriverException extends BaseScraperException{

	private static final long serialVersionUID = 1L;

	public ScraperWebDriverException(String message) {
		super(message);
	}
	
	public ScraperWebDriverException(Integer code) {
		super(code);
	}
	
	public ScraperWebDriverException(String message, Integer code) {
		super(message, code);
	}
}
