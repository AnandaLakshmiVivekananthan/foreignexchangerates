package com.fer.foreignexchangerates.service;

import com.fer.foreignexchangerates.Mapper.ResponseMapper;
import com.fer.foreignexchangerates.dto.GetAllExternalApiDto;
import com.fer.foreignexchangerates.dto.GetAllResponseDto;
import com.fer.foreignexchangerates.model.ExchangeRate;
import com.fer.foreignexchangerates.repository.ExchangeRateRepository;
import com.mgnt.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

	@Autowired
	ExchangeRateRepository exchangeRateRepository;

	@Override
	public GetAllResponseDto getAllExchangeRates() {
		ResponseMapper mapper = new ResponseMapper();
		Optional<ExchangeRate> rate = exchangeRateRepository.findLatestRecords();
		if (rate.isEmpty()) {
			GetAllExternalApiDto result = null;
			try {
				String uri = "https://api.frankfurter.app/latest";
				RestTemplate restTemplate = new RestTemplate();
				String responseString = restTemplate.getForObject(uri, String.class);
				result = JsonUtils.readObjectFromJsonString(responseString, GetAllExternalApiDto.class);
				ExchangeRate exchangeRate = new ExchangeRate();
				exchangeRate.setSource("EUR");
				exchangeRate.setDate(LocalDate.now());
				exchangeRate.setCZK(result.getRates().getCZK());
				exchangeRate.setGBP(result.getRates().getGBP());
				exchangeRate.setJPY(result.getRates().getJPY());
				exchangeRate.setCZK(result.getRates().getCZK());
				exchangeRate.setUSD(result.getRates().getUSD());
				exchangeRateRepository.save(exchangeRate);
				rate = exchangeRateRepository.findLatestRecords();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return mapper.getAllResponseMapper(rate.get());
	}
}
