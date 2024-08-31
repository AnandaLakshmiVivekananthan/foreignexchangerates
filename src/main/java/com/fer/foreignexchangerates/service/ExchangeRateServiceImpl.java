package com.fer.foreignexchangerates.service;

import com.fer.foreignexchangerates.Mapper.ResponseMapper;
import com.fer.foreignexchangerates.dto.GetAllExternalApiDto;
import com.fer.foreignexchangerates.dto.GetAllResponseDto;
import com.fer.foreignexchangerates.dto.GetTargetResponseDto;
import com.fer.foreignexchangerates.model.ExchangeRate;
import com.fer.foreignexchangerates.repository.ExchangeRateRepository;
import com.mgnt.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Ananda Lakshmi Vivekananthan
 */
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

	@Autowired
	ExchangeRateRepository exchangeRateRepository;

	ResponseMapper mapper = new ResponseMapper();

	@Override
	public GetAllResponseDto getAllExchangeRates() {

		Optional<ExchangeRate> rate = exchangeRateRepository.findLatestRecords();
		if (rate.isEmpty()) {
			try {
				GetAllExternalApiDto result = null;
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
				exchangeRate.setUSD(result.getRates().getUSD());
				exchangeRateRepository.save(exchangeRate);

				rate = exchangeRateRepository.findLatestRecords();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return mapper.mapGetAllExchangeRates(rate.get());
	}

	public GetTargetResponseDto getTargetCurrency(String targetCurrency) {
		List<ExchangeRate> rateList = exchangeRateRepository.findTargetExchangeRates();
		switch (targetCurrency) {
			case "gbp":
				return mapper.mapGBPExchangeRate(rateList);

			case "czk":
				break;

			case "jpy":
				break;

			case "usd":
				break;
		}

//		return rateList;
		return null;
	}
}
