package com.example.microservices.limitsservice.controller;

import com.example.microservices.limitsservice.Configuration;
import com.example.microservices.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
    @Autowired
    private Configuration configuration;
    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsConfiguration(){
        return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @GetMapping("/errorMessage")
    public LimitConfiguration retrieveConfiguration(){
        throw new RuntimeException("not available");
    }

    public LimitConfiguration fallbackMethod(){
        return new LimitConfiguration(99,9);
    }
}
