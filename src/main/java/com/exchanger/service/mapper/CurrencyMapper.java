package com.exchanger.service.mapper;

import com.exchanger.model.Currency;
import com.exchanger.model.dto.CurrencyApi;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class CurrencyMapper {

    public Currency toCurrency(CurrencyApi currencyApi) {
        Currency currency = new Currency();
        currency.setCcy(currencyApi.getCcy());
        currency.setBase_ccy(currencyApi.getBase_ccy());
        currency.setPurchasePrice(currencyApi.getBuy());
        currency.setSellingPrice(currencyApi.getSale());
        return currency;
    }
}
