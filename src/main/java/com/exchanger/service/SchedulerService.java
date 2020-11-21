package com.exchanger.service;

import com.exchanger.model.dto.CurrencyDTO;
import com.exchanger.service.webclient.WebClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SchedulerService {

    private final WebClientService webClientService;
    private final CurrencyCRUDServiceImpl currencyService;

    @Async
    @Scheduled(cron = "0 */5 * * * ?", zone = "GMT+2")
    public void updateCurrency() {
        List<CurrencyDTO> currencies = webClientService.getCurrenciesRates();
        log.info("Currency rate updated: " + currencies);
        currencyService.save(currencyService.toCurrencyList(currencies));
    }
}
