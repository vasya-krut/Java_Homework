package com.example.Module22.controller;

import com.example.Module22.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Module22.model.Country;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/country")
public class CountryController {

    CountryService countryService = new CountryService();

    @GetMapping("/all")
    public ResponseEntity<?> getAllCountries() {
        countryService.checkCountryMapIsEmpty();
        if(!countryService.isOperationSuccess()) {
            return  ResponseEntity.ok(countryService.getOperationStatusMessage());
        }
        return new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getCountryByName(@RequestParam("countryName") String countryName) {
        countryService.checkContainsCountry(countryName);
        if(!countryService.isOperationSuccess()){
            return ResponseEntity.ok(countryService.getOperationStatusMessage());
        }
        return new ResponseEntity<>(countryService.getCountry(countryName), HttpStatus.OK);
    }

    @GetMapping("/{countryName}/population")
    public ResponseEntity<?> getPopulationByCountryName(@PathVariable("countryName") String countryName) {
        countryService.checkContainsCountry(countryName);
        if(!countryService.isOperationSuccess()){
            return ResponseEntity.ok(countryService.getOperationStatusMessage());
        }
        return new ResponseEntity<>(countryService.getCountryPopulation(countryName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveCountry(@RequestBody Country country) {
        countryService.setNewCountry(country);
        if(countryService.isOperationSuccess())
            return new ResponseEntity<>(country, HttpStatus.CREATED);
        return ResponseEntity.ok(countryService.getOperationStatusMessage());
    }

    @PutMapping
    public ResponseEntity<?> updateCountry(@RequestBody Country country) {
        countryService.updateCountry(country);
        if(countryService.isOperationSuccess())
            return new ResponseEntity<>(country, HttpStatus.CREATED);
        return ResponseEntity.ok(countryService.getOperationStatusMessage());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCountryByName(@RequestParam("countryName") String countryName) {
        countryService.deleteCountry(countryName);
        return ResponseEntity.ok(countryService.getOperationStatusMessage());
    }

}
