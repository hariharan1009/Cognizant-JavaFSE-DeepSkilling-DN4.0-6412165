package com.cognizant.restcountry.service;


import com.cognizant.restcountry.dto.CountryDTO;
import com.cognizant.restcountry.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryLookupService {

    @Autowired
    private ApplicationContext context;

    public CountryDTO getCountry(String code) {
        List<CountryDTO> countries = (List<CountryDTO>) context.getBean("countryList");

        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country code '" + code + "' not found"));
    }
}


