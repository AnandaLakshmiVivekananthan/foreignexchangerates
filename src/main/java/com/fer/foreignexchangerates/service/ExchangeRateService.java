package com.fer.foreignexchangerates.service;

import com.fer.foreignexchangerates.dto.GetAllResponseDto;
import com.fer.foreignexchangerates.model.ExchangeRate;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
public interface ExchangeRateService {
	GetAllResponseDto getAllExchangeRates();
}
