package com.exchanger.service;

import com.exchanger.model.Currency;
import com.exchanger.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyCRUDServiceImpl implements CurrencyCRUDService {

    private final CurrencyRepository currencyRepository;

    @Override
    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }
}
