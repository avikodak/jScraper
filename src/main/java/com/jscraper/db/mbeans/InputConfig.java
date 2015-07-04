package com.jscraper.db.mbeans;

import java.io.Serializable;

public class InputConfig implements Serializable{

	private static final long serialVersionUID = 750202261809626595L;
	private String type;
	private Integer length;
	private String cardType;
	private String country;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
