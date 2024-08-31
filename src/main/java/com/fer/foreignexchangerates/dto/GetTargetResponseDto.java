package com.fer.foreignexchangerates.dto;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
public class GetTargetResponseDto {

	public String source;
	public TargetRatesDto rates;

	public GetTargetResponseDto() {
	}

	public GetTargetResponseDto(String source, TargetRatesDto rates) {
		this.source = source;
		this.rates = rates;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public TargetRatesDto getRates() {
		return rates;
	}

	public void setRates(TargetRatesDto rates) {
		this.rates = rates;
	}
}
