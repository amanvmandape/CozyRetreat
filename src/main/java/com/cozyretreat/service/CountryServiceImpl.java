package com.cozyretreat.service;

import com.cozyretreat.entity.Country;
import com.cozyretreat.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    @Override
    public Country addCountry(String countryName) {
        Country country = new Country();
        country.setCountryName(countryName);
        return countryRepository.save(country);
    }

    @Override
    public Country delCountry(String countryName) {
        Country country = this.findCountry(countryName);
        if(country != null)
        {
            countryRepository.delete(country);
        }
        return country;
    }

    @Override
    public Country findCountry(String countryName) {
        Optional<Country> opt = countryRepository.findByCountryName(countryName);
        if(opt.isPresent())
        {
            return opt.get();
        }
        return null;
    }

    @Override
    public Country updateCountry(int id, String newCountryName) {
        Optional<Country> opt = countryRepository.findById(Long.valueOf(id));
        if(opt.isPresent())
        {
            Country country = opt.get();
            country.setCountryName(newCountryName);
            countryRepository.save(country);
            return country;
        }
        return null;
    }
}
