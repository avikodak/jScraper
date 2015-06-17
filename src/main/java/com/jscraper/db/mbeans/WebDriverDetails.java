package com.jscraper.db.mbeans;

public class WebDriverDetails {

	private Integer defaultTimeout;
	private Boolean enableJS;

	public Integer getDefaultTimeout() {
		return defaultTimeout;
	}

	public void setDefaultTimeout(Integer defaultTimeout) {
		this.defaultTimeout = defaultTimeout;
	}

	public Boolean getEnableJS() {
		return enableJS;
	}

	public void setEnableJS(Boolean enableJS) {
		this.enableJS = enableJS;
	}

}
