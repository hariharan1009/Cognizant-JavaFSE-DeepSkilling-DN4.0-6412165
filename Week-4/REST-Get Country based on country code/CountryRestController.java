package com.cognizant.restcountry.controller;

import com.cognizant.restcountry.dto.CountryDTO;
import com.cognizant.restcountry.service.CountryLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryRestController {

    @Autowired
    private CountryLookupService service;

    @GetMapping("/{code}")
    public CountryDTO getCountry(@PathVariable String code) {
        return service.getCountry(code);
    }
}


