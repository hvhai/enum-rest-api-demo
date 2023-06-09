package com.codehunter.enumrestapidemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/echos")
@Slf4j
public class EchoController {

    @Autowired
    @Qualifier("echoClient")
    private WebClient echoClient;

    @GetMapping
    public String getEcho() {
        Object block = echoClient.get()
                .uri("/get?foo1=" + "abc")
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(Object.class))
                .block();
        String result = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            result = objectMapper.writeValueAsString(block);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return result;
    }
}
