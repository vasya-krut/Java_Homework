package com.example.Module22.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Module22.model.Country;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final Map<String, Country> countries = new HashMap();
    private String operationStatusMessage;
    private boolean operationSuccess;

    public Map<String, Country> getCountries() {
        return countries;
    }

    private Country getCountry(String countryName){
        return countries.get(countryName);
    }

    private int getCountryPopulation(String countryName){
        return countries.get(countryName).getPopulation();
    }

    public void setNewCountry(Country country){
        checkNotContainsCountry(country.getName());
        if(!operationSuccess)return;

        checkErrorCountryName(country.getName());
        if(!operationSuccess)return;

        checkErrorCountryPopulation(country.getPopulation());
        if(!operationSuccess)return;

        countries.put(country.getName(), country);
    }

    private void updateCountryMethod(Country country){
        checkContainsCountry(country.getName());
        if(!operationSuccess)return;

        checkErrorCountryName(country.getName());
        if(!operationSuccess)return;

        checkErrorCountryPopulation(country.getPopulation());
        if(!operationSuccess)return;

        countries.put(country.getName(), country);
    }

    private void deleteCountry(String countryName){
        checkContainsCountry(countryName);
        if(operationSuccess){
            countries.remove(countryName);
        }
    }

    private String errorCountryNameMessage(){
        return "Страны с таким названием не может существовать!";
    }

    private String errorCountryPopulationMessage(){
        return "Страны с таким количеством населения не может существовать!";
    }

    private String errorCountryMapIsEmptyMessage(){
        return "Список стран пуст!";
    }

    private String errorCountryNotContainsMessage(){
        return "Страны с таким названием не сущестувет в списке!";
    }

    private String errorCountryContainsMessage(){
        return "Страна с таким названием уже существует в списке!";
    }

    private String successfullOperationMessage(){
        return "Операция выполнена успешно";
    }


    private void checkCountryMapIsEmpty(){
        if(countries.isEmpty()){
            operationStatusMessage = errorCountryMapIsEmptyMessage();
            operationSuccess = false;
        }
        else{
            operationSuccess = true;
            operationStatusMessage = successfullOperationMessage();
        }
    }

    private void checkErrorCountryPopulation(int pop){
        operationSuccess = (pop > 0 && pop <= 2_000_000_000);
        if(!operationSuccess){
            operationStatusMessage = errorCountryPopulationMessage();
        }
        else{
            operationStatusMessage = successfullOperationMessage();}

    }

    private void checkErrorCountryName(String countryName){
        if (countryName.isEmpty() || !countryName.chars().allMatch(Character::isLetter)){
            operationSuccess = false;
            operationStatusMessage = errorCountryNameMessage();
        }
        else{
            operationSuccess = true;
            operationStatusMessage = successfullOperationMessage();
        }
    }

    private void checkContainsCountry(String countryName){
        if(countries.containsKey(countryName)){
            operationSuccess = true;
            operationStatusMessage = successfullOperationMessage();
        }
        else{
            operationStatusMessage = errorCountryNotContainsMessage();
            operationSuccess = false;
        }
    }

    private void checkNotContainsCountry(String countryName){
        if(!countries.containsKey(countryName)){
            operationSuccess = true;
            operationStatusMessage = successfullOperationMessage();
        }
        else{
            operationStatusMessage = errorCountryContainsMessage();
            operationSuccess = false;
        }
    }









    @GetMapping("/all")
    public ResponseEntity<?> getAllCountries() {
        checkCountryMapIsEmpty();
        if(!operationSuccess) {
            return  ResponseEntity.ok(operationStatusMessage);
        }
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getCountryByName(@RequestParam("countryName") String countryName) {
        checkContainsCountry(countryName);
        if(!operationSuccess){
            return ResponseEntity.ok(operationStatusMessage);
        }
        return new ResponseEntity<>(getCountry(countryName), HttpStatus.OK);
    }

    @GetMapping("/{countryName}/population")
    public ResponseEntity<?> getPopulationByCountryName(@PathVariable("countryName") String countryName) {
        checkContainsCountry(countryName);
        if(!operationSuccess){
            return ResponseEntity.ok(operationStatusMessage);
        }
        return new ResponseEntity<>(getCountryPopulation(countryName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveCountry(@RequestBody Country country) {
        setNewCountry(country);
        if(operationSuccess)
            return new ResponseEntity<>(country, HttpStatus.CREATED);
        return ResponseEntity.ok(operationStatusMessage);
    }

    @PutMapping
    public ResponseEntity<?> updateCountry(@RequestBody Country country) {
        updateCountryMethod(country);
        if(operationSuccess)
            return new ResponseEntity<>(country, HttpStatus.CREATED);
        return ResponseEntity.ok(operationStatusMessage);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCountryByName(@RequestParam("countryName") String countryName) {
        deleteCountry(countryName);
        return ResponseEntity.ok(operationStatusMessage);
    }

}
