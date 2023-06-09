package com.codehunter.enumrestapidemo.config;

import io.netty.handler.logging.LogLevel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;


@Configuration
public class WebConfig {

    @Bean(name = "echoClient")
//    public WebClient loanDocumentClient(@Value("${echourl}") final String docURL) {
    public WebClient loanDocumentClient(@Value("${echourl}") final String docURL) {

        WebClient.Builder client = createDocumentWebClientBuilder();
        return client.baseUrl(docURL).build();
    }

    private WebClient.Builder createDocumentWebClientBuilder() {
        return WebClient.builder()
                .defaultHeaders(headers -> {
                    headers.add(HttpHeaders.ACCEPT, "*/*");
                })
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(cfg -> cfg.defaultCodecs().maxInMemorySize(100000000))
                        .build())
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create()
                        .wiretap("reactor.netty.http.client.HttpClient", LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL)
                        .followRedirect(true)
                        .secure()));
    }
}
