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
    public List<Country> searchByName(String keyword) {
        return countryRepository.findByNameContainingIgnoreCase(keyword);
    }

    @Transactional
    public List<Country> searchByNameOrdered(String keyword) {
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(keyword);
    }

    @Transactional
    public List<Country> searchByNameStartingWithIgnoreCase(String keyword) {
        return countryRepository.findByNameStartingWith(keyword);
    }

    @Transactional
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }
}
