package com.jscraper.db.mbeans;

public class InputAction extends BaseAction {

	private static final long serialVersionUID = 3055181984331632268L;
	private ElementSelector elementSelector;
	private Boolean inputAllElements = false;
	private Integer index = 0;
	private InputConfig inputConfig;
	
	public InputAction(ElementSelector elementSelector) {
		super();
		this.elementSelector = elementSelector;
	}

	public ElementSelector getElementSelector() {
		return elementSelector;
	}

	public void setElementSelector(ElementSelector elementSelector) {
		this.elementSelector = elementSelector;
	}

	public Boolean getInputAllElements() {
		return inputAllElements;
	}

	public void setInputAllElements(Boolean inputAllElements) {
		this.inputAllElements = inputAllElements;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public InputConfig getInputConfig() {
		return inputConfig;
	}

	public void setInputConfig(InputConfig inputConfig) {
		this.inputConfig = inputConfig;
	}

}
