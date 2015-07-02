package com.jscraper.db.mbeans;

import java.io.Serializable;

public class IFrameSwitchAction implements Serializable{

	private static final long serialVersionUID = 6994253267073766156L;
	
	private Integer index;
	private String idOrName;
	private ElementSelector elementSelector;

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
	
	
}
