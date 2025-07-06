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

		testAddCountry();
		testUpdateCountry();
		testGetCountryByCode();
		testDeleteCountry();
		testSearchCountriesByPartialName();
	}

	private static void testAddCountry() {
		LOGGER.info("Start testAddCountry");
		Country country = new Country("ZZ", "Zootopia");
		countryService.addCountry(country);
		LOGGER.info("Added country: {}", countryService.findByCode("ZZ"));
		LOGGER.info("End testAddCountry\n");
	}

	private static void testUpdateCountry() {
		LOGGER.info("Start testUpdateCountry");
		Country country = countryService.findByCode("ZZ");
		if (country != null) {
			country.setName("Zootopia - Updated");
			countryService.updateCountry(country);
			LOGGER.info("Updated country: {}", countryService.findByCode("ZZ"));
		} else {
			LOGGER.warn("Country ZZ not found to update");
		}
		LOGGER.info("End testUpdateCountry\n");
	}

	private static void testGetCountryByCode() {
		LOGGER.info("Start testGetCountryByCode");
		Country country = countryService.findByCode("IN");
		LOGGER.info("Country with code IN: {}", country);
		LOGGER.info("End testGetCountryByCode\n");
	}

	private static void testDeleteCountry() {
		LOGGER.info("Start testDeleteCountry");
		countryService.deleteCountry("ZZ");
		Country deleted = countryService.findByCode("ZZ");
		LOGGER.info("Deleted country ZZ, now found: {}", deleted);
		LOGGER.info("End testDeleteCountry\n");
	}

	private static void testSearchCountriesByPartialName() {
		LOGGER.info("Start testSearchCountriesByPartialName");
		List<Country> countries = countryService.searchCountriesByName("an");
		countries.forEach(c -> LOGGER.info("Match: {}", c));
		LOGGER.info("End testSearchCountriesByPartialName\n");
	}
}
