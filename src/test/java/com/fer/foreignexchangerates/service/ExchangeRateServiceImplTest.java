package com.fer.foreignexchangerates.service;

import com.fer.foreignexchangerates.dto.GetAllResponseDto;
import com.fer.foreignexchangerates.model.ExchangeRate;
import com.fer.foreignexchangerates.repository.ExchangeRateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
@ExtendWith(MockitoExtension.class)
public class ExchangeRateServiceImplTest {

	@InjectMocks
	ExchangeRateServiceImpl service;
	@Mock
	private ExchangeRateRepository repository;

	@Test
	public void testGetAllExchangeRates() {
		ExchangeRate mockExchangeRate = new ExchangeRate();
		mockExchangeRate.setSource("EUR");
		mockExchangeRate.setDate(LocalDate.now());
		mockExchangeRate.setCZK(1.525);
		mockExchangeRate.setGBP(0.858);
		mockExchangeRate.setJPY(25.2569);
		mockExchangeRate.setUSD(1.2585);

		when(repository.findLatestRecords()).thenReturn(Optional.of(mockExchangeRate));

		GetAllResponseDto responseDto = service.getAllExchangeRates();

		assertThat(responseDto.getDate()).isEqualTo(mockExchangeRate.getDate());
		assertThat(responseDto.getSource()).isEqualTo(mockExchangeRate.getSource());
		assertThat(responseDto.getRates().size()).isEqualTo(4);
		assertThat(responseDto.getRates().get(1).getValue()).isEqualTo(mockExchangeRate.getGBP());
	}
}
