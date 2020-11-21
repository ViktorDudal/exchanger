package com.exchanger.service.webclient;

import com.exchanger.model.dto.CurrencyDto;

import java.util.List;

public interface WebClientService {

    List<CurrencyDto> getCurrenciesRates();
}
