package com.ridao.microservices.limitsservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ridao.microservices.limitsservice.domain.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitsConfiguration retrieveLimitsFromConfigurations() {
        return new LimitsConfiguration(configuration.getMinimum(),
                configuration.getMaximum());
    }

    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration")
    public LimitsConfiguration retrieveConfigurations() {
        throw new RuntimeException("Method not available");
    }

    public LimitsConfiguration fallbackRetrieveConfiguration() {
        return new LimitsConfiguration(1,9);
    }

}
