package com.fer.foreignexchangerates.controller;

import com.fer.foreignexchangerates.dto.GetAllResponseDto;
import com.fer.foreignexchangerates.dto.GetTargetResponseDto;
import com.fer.foreignexchangerates.service.ExchangeRateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
@RestController
@RequestMapping("/fx")
public class ExchangeRatesController {

	@Autowired
	ExchangeRateServiceImpl rateService;

	@GetMapping("/")
	public GetAllResponseDto getAllExchangeRates(){
		return rateService.getAllExchangeRates();
	}

	@GetMapping("/{targetCurrency}")
	public GetTargetResponseDto getTargetCurrency(@PathVariable String targetCurrency) {
		return rateService.getTargetCurrency(targetCurrency);
	}

}
