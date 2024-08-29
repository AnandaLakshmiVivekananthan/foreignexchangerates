package com.fer.foreignexchangerates.dto;

import java.time.LocalDate;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
public class GetAllExternalApiDto {

	private Double amount;
	private String base;
	private LocalDate date;
	private ExternalRatesDto rates;

	public GetAllExternalApiDto() {
	}

	public GetAllExternalApiDto(Double amount, String base, LocalDate date, ExternalRatesDto rates) {
		this.amount = amount;
		this.base = base;
		this.date = date;
		this.rates = rates;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public ExternalRatesDto getRates() {
		return rates;
	}

	public void setRates(ExternalRatesDto rates) {
		this.rates = rates;
	}
}

