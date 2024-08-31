package com.fer.foreignexchangerates.dto;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
public class TargetRatesDto {

	public DateObjectDto date;

	public TargetRatesDto(DateObjectDto date) {
		this.date = date;
	}

	public TargetRatesDto() {
	}

	public DateObjectDto getDate() {
		return date;
	}

	public void setDate(DateObjectDto date) {
		this.date = date;
	}
}

