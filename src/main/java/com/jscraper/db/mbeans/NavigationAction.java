package com.jscraper.db.mbeans;

public class NavigationAction extends BaseAction {

	private static final long serialVersionUID = -5796016453173074202L;
	private String type;
	private String url;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
