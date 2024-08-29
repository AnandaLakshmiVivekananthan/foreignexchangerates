package com.fer.foreignexchangerates.Mapper;

import com.fer.foreignexchangerates.dto.GetAllResponseDto;
import com.fer.foreignexchangerates.dto.RateDto;
import com.fer.foreignexchangerates.model.ExchangeRate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ananda Lakshmi Vivekananthan
 */

public class ResponseMapper {
	public GetAllResponseDto getAllResponseMapper(ExchangeRate rate) {
		GetAllResponseDto responseDto = new GetAllResponseDto();
		responseDto.setDate(rate.getDate());
		responseDto.setSource(rate.getSource());
		RateDto usdrate = new RateDto("USD", rate.getUSD());
		RateDto gbprate = new RateDto("GBP", rate.getGBP());
		RateDto jpyrate = new RateDto("JPY", rate.getJPY());
		RateDto czkrate = new RateDto("CZK", rate.getCZK());
		List<RateDto> rates = new ArrayList<>();
		rates.add(usdrate);
		rates.add(gbprate);
		rates.add(jpyrate);
		rates.add(czkrate);
		responseDto.setRates(rates);
		return responseDto;
	}
}
