package com.fer.foreignexchangerates.dto;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
public class RateDto {
	private String target;
	private Double value;

	public RateDto(String target, Double value) {
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

	@Override
	public String toString() {
		return "RateDto{" +
				"target='" + target + '\'' +
				", value=" + value +
				'}';
	}
}
