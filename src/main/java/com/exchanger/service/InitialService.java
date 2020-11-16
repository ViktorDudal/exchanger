package com.exchanger.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLException;

@Slf4j
@Service
@AllArgsConstructor
public class InitialService {

    private final SchedulerService schedulerService;

    @PostConstruct
    private void init() throws SSLException {
        schedulerService.updateCurrency();
    }
}
