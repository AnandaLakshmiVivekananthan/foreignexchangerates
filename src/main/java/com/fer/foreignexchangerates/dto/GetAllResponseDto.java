package com.fer.foreignexchangerates.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
public class GetAllResponseDto {

	String source;
	public LocalDate date;
	private List<RateDto> rates;

	public GetAllResponseDto() {
	}

	public GetAllResponseDto(LocalDate date, String source, List<RateDto> rates) {
		this.date = date;
		this.source = source;
		this.rates = rates;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<RateDto> getRates() {
		return rates;
	}

	public void setRates(List<RateDto> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "GetAllResponseDto{" +
				"date=" + date +
				", source='" + source + '\'' +
				", rates=" + rates.toString() +
				'}';
	}
}
