package com.exchanger.service.webclient;

import com.exchanger.model.Currency;
import com.exchanger.model.dto.CurrencyApi;
import com.exchanger.service.mapper.CurrencyMapper;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

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
        final SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();
        HttpClient httpClient =HttpClient.create().secure(t -> t.sslContext(sslContext));
        WebClient currencyClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(EXCHANGE_API)
                .build();
        CurrencyApi[] currencyApi =currencyClient.get().retrieve().bodyToMono(CurrencyApi[].class).block();
        log.info("API = " + EXCHANGE_API);
        return currencyMapper.toCurrency(currencyApi[0]);
    }
}
