package com.exchanger.service;

import com.exchanger.model.Currency;
import com.exchanger.model.dto.CurrencyDto;
import com.exchanger.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public void save(List<Currency> currencies) {
        currencyRepository.saveAll(currencies);
    }

    public List<Currency> toCurrencyList(List<CurrencyDto> currencyDTOList) {
        return currencyDTOList.stream().map(this::toCurrency).collect(Collectors.toList());
    }

    private Currency toCurrency(CurrencyDto currencyDTO) {
        Currency currency = new Currency();
        currency.setDate(Instant.now());
        currency.setConvertFrom(currencyDTO.getCcy());
        currency.setConvertTo(currencyDTO.getBase_ccy());
        currency.setPurchasePrice(currencyDTO.getBuy());
        currency.setSellingPrice(currencyDTO.getSale());
        return currency;
    }
}
