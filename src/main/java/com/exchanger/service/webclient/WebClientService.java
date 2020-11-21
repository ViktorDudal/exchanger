package com.exchanger.service.webclient;

import com.exchanger.model.dto.CurrencyDTO;

import java.util.List;

public interface WebClientService {

    List<CurrencyDTO> getCurrenciesRates();
}
