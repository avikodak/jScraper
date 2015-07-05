package com.jscraper.db.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JobConfig implements Serializable {

	private static final long serialVersionUID = 1151709703838672886L;
	private WebDriverDetails webDriverDetails;
	private Integer jobCount;
	private String baseUrl;
	private List<BaseAction> actionsList = new ArrayList<BaseAction>();

	public JobConfig(String webDriverType){
		this.webDriverDetails = new WebDriverDetails(webDriverType);
	}
	
	public JobConfig(String webDriverType,String baseUrl){
		this.baseUrl = baseUrl;
		this.webDriverDetails = new WebDriverDetails(webDriverType);
	}
	
	public JobConfig(WebDriverDetails webDriverDetails,String baseUrl){
		this.baseUrl = baseUrl;
		this.webDriverDetails = webDriverDetails;
	}
	
	public WebDriverDetails getWebDriverDetails() {
		return webDriverDetails;
	}

	public void setWebDriverDetails(WebDriverDetails webDriverDetails) {
		this.webDriverDetails = webDriverDetails;
	}

	public Integer getJobCount() {
		return jobCount;
	}

	public void setJobCount(Integer jobCount) {
		this.jobCount = jobCount;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public List<BaseAction> getActionsList() {
		return actionsList;
	}

	public void setActionsList(List<BaseAction> actionsList) {
		this.actionsList = actionsList;
	}

}
