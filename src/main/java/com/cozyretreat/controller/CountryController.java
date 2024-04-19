package com.cozyretreat.controller;

import com.cozyretreat.entity.Country;
import com.cozyretreat.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/country")
public class CountryController {

    private final CountryService countryService;
    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody String countryName) {
        Country country = countryService.addCountry(countryName);
        return new ResponseEntity<>(country, HttpStatus.CREATED);
    }

    @PostMapping("/del")
    public ResponseEntity<?> deleteCountry(@RequestBody String countryName) {
        Country country = countryService.delCountry(countryName);
        if(country!=null) {
            return new ResponseEntity<>(country, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Record Not Found!",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/find")
    public ResponseEntity<?> findCountry(@RequestBody String countryName) {
        Country country = countryService.findCountry(countryName);
        if(country!=null) {
            return new ResponseEntity<>(country, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Record Not Found!", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCountry(@RequestParam int id, @RequestBody String newCountryName) {
        Country country = countryService.updateCountry(id, newCountryName);
        if(country!=null) {
            return new ResponseEntity<>(country, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Record Not Found!", HttpStatus.NOT_FOUND);
        }
    }
}
