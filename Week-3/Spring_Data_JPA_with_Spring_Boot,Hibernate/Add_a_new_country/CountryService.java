package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public Country findByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    public Country updateCountry(Country country) {
        if (countryRepository.existsById(country.getCode())) {
            return countryRepository.save(country);
        } else {
            throw new IllegalArgumentException("Country with code " + country.getCode() + " does not exist");
        }
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Transactional
    public List<Country> searchCountriesByName(String partialName) {
        return countryRepository.findByNameContainingIgnoreCase(partialName);
    }
}
