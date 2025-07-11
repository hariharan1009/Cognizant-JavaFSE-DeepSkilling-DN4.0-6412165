package com.cognizant.restcountry.dto;

public class CountryDTO {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code.toUpperCase(); // Normalize to uppercase
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


