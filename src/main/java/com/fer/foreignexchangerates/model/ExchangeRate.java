package com.fer.foreignexchangerates.model;


import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
@Entity
@Table(name = "exchangerates")
public class ExchangeRate {


	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "er_seq"
	)
	@SequenceGenerator(
			name = "er_seq"
	)
	@Column(name = "id")
	private Integer id;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "source")
	private String source;

	@Column(name = "gbp")
	private Double GBP;

	@Column(name = "usd")
	private Double USD;

	@Column(name = "jpy")
	private Double JPY;

	@Column(name = "czk")
	private Double CZK;

	public ExchangeRate() {
	}

	public ExchangeRate(Integer id, LocalDate date, String source, Double gBP, Double uSD, Double jPY, Double cZK) {
		this.id = id;
		this.date = date;
		this.source = source;
		GBP = gBP;
		USD = uSD;
		JPY = jPY;
		CZK = cZK;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getGBP() {
		return GBP;
	}

	public void setGBP(Double gBP) {
		GBP = gBP;
	}

	public Double getUSD() {
		return USD;
	}

	public void setUSD(Double uSD) {
		USD = uSD;
	}

	public Double getJPY() {
		return JPY;
	}

	public void setJPY(Double jPY) {
		JPY = jPY;
	}

	public Double getCZK() {
		return CZK;
	}

	public void setCZK(Double cZK) {
		CZK = cZK;
	}


}