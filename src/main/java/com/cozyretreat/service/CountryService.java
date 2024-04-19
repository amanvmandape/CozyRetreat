package com.cozyretreat.service;

import com.cozyretreat.entity.Country;

public interface CountryService {
    Country addCountry(String countryName);
    Country delCountry(String countryName);
    Country findCountry(String countryName);
    Country updateCountry(int id, String newCountryName);
}
