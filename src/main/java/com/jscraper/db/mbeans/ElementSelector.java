package com.jscraper.db.mbeans;

import java.io.Serializable;

public class ElementSelector implements Serializable {

	private static final long serialVersionUID = -793927615730578696L;
	private String type;
	private String identifier;
	private Integer index = 0;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	
}
