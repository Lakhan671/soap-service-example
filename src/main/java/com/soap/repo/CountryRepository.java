package com.soap.repo;

import io.spring.guides.gs_producing_web_service.Currency;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {
    private static final Map<String, io.spring.guides.gs_producing_web_service.Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        io.spring.guides.gs_producing_web_service.Country spain = new io.spring.guides.gs_producing_web_service.Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);

        countries.put(spain.getName(), spain);

        io.spring.guides.gs_producing_web_service.Country poland = new io.spring.guides.gs_producing_web_service.Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(io.spring.guides.gs_producing_web_service.Currency.PLN);
        poland.setPopulation(38186860);

        countries.put(poland.getName(), poland);

        io.spring.guides.gs_producing_web_service.Country uk = new io.spring.guides.gs_producing_web_service.Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(io.spring.guides.gs_producing_web_service.Currency.GBP);
        uk.setPopulation(63705000);

        countries.put(uk.getName(), uk);
    }

    public io.spring.guides.gs_producing_web_service.Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return countries.get(name);
    }
}