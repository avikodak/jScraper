package com.jscraper.db.mbeans;

import java.io.Serializable;
import java.util.List;

public class JobConfig implements Serializable {

	private static final long serialVersionUID = 1151709703838672886L;
	private WebDriverDetails webDriverDetails;
	private Integer jobCount;
	private List<BaseAction> actionsList;

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

	public List<BaseAction> getActionsList() {
		return actionsList;
	}

	public void setActionsList(List<BaseAction> actionsList) {
		this.actionsList = actionsList;
	}

}
