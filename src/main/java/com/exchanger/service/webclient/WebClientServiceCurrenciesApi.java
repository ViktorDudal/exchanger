package com.exchanger.service.webclient;

import com.exchanger.model.Currency;
import com.exchanger.model.dto.CurrencyApi;
import com.exchanger.service.mapper.CurrencyMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.net.ssl.SSLException;

@Slf4j
@AllArgsConstructor
@Service
@Primary
public class WebClientServiceCurrenciesApi implements WebClientService {

    public static final String EXCHANGE_API = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
    private final CurrencyMapper currencyMapper;

    @Override
    public Currency getCurrencyRate() throws SSLException {
        WebClient currencyClient = WebClient.builder()
                .baseUrl(EXCHANGE_API)
                .build();
        CurrencyApi[] currencyApi =currencyClient.get().retrieve().bodyToMono(CurrencyApi[].class).block();
        log.info("API = " + EXCHANGE_API);
        return currencyMapper.toCurrency(currencyApi[0]);
    }
}
