package com.exchanger.service.webclient;

import com.exchanger.model.Currency;

import javax.net.ssl.SSLException;

public interface WebClientService {

    Currency getCurrencyRate() throws SSLException;
}
