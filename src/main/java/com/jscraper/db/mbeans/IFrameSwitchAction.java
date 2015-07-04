package com.jscraper.db.mbeans;

import java.io.Serializable;

public class IFrameSwitchAction extends BaseAction implements Serializable {

	private static final long serialVersionUID = 6994253267073766156L;

	private Integer index;
	private String idOrName;
	private ElementSelector elementSelector;
	private Boolean switchToDefault;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getIdOrName() {
		return idOrName;
	}

	public void setIdOrName(String idOrName) {
		this.idOrName = idOrName;
	}

	public ElementSelector getElementSelector() {
		return elementSelector;
	}

	public void setElementSelector(ElementSelector elementSelector) {
		this.elementSelector = elementSelector;
	}

	public Boolean getSwitchToDefault() {
		return switchToDefault;
	}

	public void setSwitchToDefault(Boolean switchToDefault) {
		this.switchToDefault = switchToDefault;
	}

}
