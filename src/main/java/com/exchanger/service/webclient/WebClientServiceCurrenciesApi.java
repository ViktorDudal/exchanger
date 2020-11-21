package com.exchanger.service.webclient;

import com.exchanger.model.dto.CurrencyDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
@Service
@Primary
public class WebClientServiceCurrenciesApi implements WebClientService {

    public static final String EXCHANGE_API = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

    @Override
    public List<CurrencyDto> getCurrenciesRates() {
        WebClient currencyClient = WebClient.builder()
                .baseUrl(EXCHANGE_API)
                .build();
        return Arrays.asList(Objects.requireNonNull(currencyClient.get().retrieve().bodyToMono(CurrencyDto[].class).block()));
    }
}
