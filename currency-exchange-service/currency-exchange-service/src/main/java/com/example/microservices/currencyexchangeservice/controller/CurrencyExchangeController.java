package com.example.microservices.currencyexchangeservice.controller;

import com.example.microservices.currencyexchangeservice.dao.CurrencyExchangeRepository;
import com.example.microservices.currencyexchangeservice.model.ExchangeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;


    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue = currencyExchangeRepository.findByFromAndTo(from,to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        logger.info("{}",exchangeValue);
        return exchangeValue;
    }
}