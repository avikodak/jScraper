package com.jscraper.db.mbeans;

public class ClickAction extends BaseAction {

	private static final long serialVersionUID = -5990447015179942448L;
	private ElementSelector elementSelector;
	private Boolean clickOnEachElement = false;
	private Boolean doubleClick = false;
	private Boolean contextClick = false;

	public ClickAction(ElementSelector elementSelector) {
		super();
		this.elementSelector = elementSelector;
	}

	public ElementSelector getElementSelector() {
		return elementSelector;
	}

	public void setElementSelector(ElementSelector elementSelector) {
		this.elementSelector = elementSelector;
	}

	public Boolean getClickOnEachElement() {
		return clickOnEachElement;
	}

	public void setClickOnEachElement(Boolean clickOnEachElement) {
		this.clickOnEachElement = clickOnEachElement;
	}

	public Boolean getDoubleClick() {
		return doubleClick;
	}

	public void setDoubleClick(Boolean doubleClick) {
		this.doubleClick = doubleClick;
	}

	public Boolean getContextClick() {
		return contextClick;
	}

	public void setContextClick(Boolean contextClick) {
		this.contextClick = contextClick;
	}

}
