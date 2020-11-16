package com.exchanger.service;

import com.exchanger.model.Currency;
import com.exchanger.service.webclient.WebClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLException;

@Slf4j
@Service
@AllArgsConstructor
public class SchedulerService {

    private final WebClientService webClientService;
    private final CurrencyService currencyService;

    @Async
    @Scheduled(cron = "0 */5 * * * ?", zone = "GMT+2")
    public void updateCurrency() throws SSLException {
        Currency currency = webClientService.getCurrencyRate();
        currency.setId(1L);
        log.info("Currency rate updated: " + currency);
        currencyService.save(currency);
    }
}
