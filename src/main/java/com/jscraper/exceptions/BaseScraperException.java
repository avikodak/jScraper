package com.jscraper.exceptions;

public class BaseScraperException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;
	private Integer code;

	public BaseScraperException(Integer code) {
		super();
		this.code = code;
	}

	public BaseScraperException(String message) {
		super();
		this.message = message;
	}
	
	public BaseScraperException(String message, Integer code) {
		super();
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
