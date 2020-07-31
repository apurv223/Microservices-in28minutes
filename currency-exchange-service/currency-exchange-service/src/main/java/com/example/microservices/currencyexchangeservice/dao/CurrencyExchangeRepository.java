package com.example.microservices.currencyexchangeservice.dao;

import com.example.microservices.currencyexchangeservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue,Long> {
    public ExchangeValue findByFromAndTo(String from, String to);
}
