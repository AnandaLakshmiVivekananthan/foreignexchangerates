package com.fer.foreignexchangerates.controller;

import com.fer.foreignexchangerates.dto.GetAllResponseDto;
import com.fer.foreignexchangerates.dto.RateDto;
import com.fer.foreignexchangerates.service.ExchangeRateServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
@ExtendWith(MockitoExtension.class)
public class ExchangeRatesControllerTest {

	@InjectMocks
	ExchangeRatesController controller;

	@Mock
	ExchangeRateServiceImpl service;

	@Test
	public void testGetAllExchangeRates() {

		GetAllResponseDto mockResponse = new GetAllResponseDto();
		mockResponse.setSource("EUR");
		mockResponse.setDate(LocalDate.now());
		List<RateDto> rates = new ArrayList<>();
		rates.add(new RateDto("GBP", 0.8585));
		rates.add(new RateDto("USD", 1.1585));
		rates.add(new RateDto("JPY", 25.205));
		mockResponse.setRates(rates);

		when(service.getAllExchangeRates()).thenReturn(mockResponse);

		GetAllResponseDto response = controller.getAllExchangeRates();
		System.out.println(response.toString());

		assertThat(response.getSource()).isEqualTo(mockResponse.getSource());
		assertThat(response.getDate()).isEqualTo(mockResponse.getDate());
		assertThat(response.getRates().size()).isEqualTo(3);
		assertThat(response.getRates().get(1)).isEqualTo(mockResponse.getRates().get(1));


	}
}
