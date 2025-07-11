package com.cognizant.restcountry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:country.xml")
public class RestCountryApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestCountryApplication.class, args);
    }
}


