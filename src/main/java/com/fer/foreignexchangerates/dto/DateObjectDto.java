package com.fer.foreignexchangerates.dto;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
public class DateObjectDto {

	String target;
	Double value;

	public DateObjectDto(String target, Double value) {
		this.target = target;
		this.value = value;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
