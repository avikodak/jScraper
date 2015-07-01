package com.jscraper.db.mbeans;

public class ClickAction extends BaseAction {

	private static final long serialVersionUID = -5990447015179942448L;
	private ElementSelector elementSelector;

	public ElementSelector getElementSelector() {
		return elementSelector;
	}

	public void setElementSelector(ElementSelector elementSelector) {
		this.elementSelector = elementSelector;
	}
	
}
