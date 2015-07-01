package com.jscraper.db.mbeans;

public class WebDriverDetails {

	private String type;
	private FileLocationDetails exeLocation;
	private Boolean enableJS;
	private Integer defaultTimeout;
	private String browserName;
	private String version;
	private BrowsingLocationDetails proxyLocation;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public FileLocationDetails getExeLocation() {
		return exeLocation;
	}

	public void setExeLocation(FileLocationDetails exeLocation) {
		this.exeLocation = exeLocation;
	}

	public Boolean getEnableJS() {
		return enableJS;
	}

	public void setEnableJS(Boolean enableJS) {
		this.enableJS = enableJS;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public BrowsingLocationDetails getProxyLocation() {
		return proxyLocation;
	}

	public void setProxyLocation(BrowsingLocationDetails proxyLocation) {
		this.proxyLocation = proxyLocation;
	}

	public Integer getDefaultTimeout() {
		return defaultTimeout;
	}

	public void setDefaultTimeout(Integer defaultTimeout) {
		this.defaultTimeout = defaultTimeout;
	}

}
