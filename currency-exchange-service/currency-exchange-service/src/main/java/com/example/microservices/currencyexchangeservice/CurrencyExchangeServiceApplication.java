package com.example.microservices.currencyexchangeservice;

import brave.sampler.Sampler;
import com.example.microservices.currencyexchangeservice.dao.CurrencyExchangeRepository;
import com.example.microservices.currencyexchangeservice.model.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@EnableDiscoveryClient
@SpringBootApplication
public class CurrencyExchangeServiceApplication implements CommandLineRunner {

	@Autowired
	CurrencyExchangeRepository currencyExchangeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		currencyExchangeRepository.save(new ExchangeValue(10001L,"USD","INR", BigDecimal.valueOf(65)));
		currencyExchangeRepository.save(new ExchangeValue(10002L,"EUR","INR", BigDecimal.valueOf(75)));
		currencyExchangeRepository.save(new ExchangeValue(10003L,"USD","EUR", BigDecimal.valueOf(160)));

	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
