package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		LOGGER.info("Inside main");

		Country country = new Country("IN", "India");
		countryService.saveCountry(country);

		testSearchCountriesByPartialName();
		testSearchCountriesByPartialNameOrdered();
		testSearchCountriesByStartingName();
	}

	private static void testSearchCountriesByPartialName() {
		LOGGER.info("Start testSearchCountriesByPartialName");
		List<Country> countries = countryService.searchByName("in");
		countries.forEach(c -> LOGGER.info("Match: {}", c));
		LOGGER.info("End testSearchCountriesByPartialName\n");
	}

	private static void testSearchCountriesByPartialNameOrdered() {
		LOGGER.info("Start testSearchCountriesByPartialNameOrdered");
		List<Country> countries = countryService.searchByNameOrdered("in");
		countries.forEach(c -> LOGGER.info("Match: {}", c));
		LOGGER.info("End testSearchCountriesByPartialNameOrdered\n");
	}

	private static void testSearchCountriesByStartingName() {
		LOGGER.info("Start testSearchCountriesByStartingName");
		List<Country> countries = countryService.searchByNameStartingWithIgnoreCase("in");
		countries.forEach(c -> LOGGER.info("Match: {}", c));
		LOGGER.info("End testSearchCountriesByStartingName\n");
	}
}
