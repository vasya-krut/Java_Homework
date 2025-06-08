package com.example.Module22.service;

import com.example.Module22.model.Country;

import java.util.HashMap;
import java.util.Map;

public class CountryService {

    private final Map<String, Country> countries = new HashMap();
    private String operationStatusMessage;
    private boolean operationSuccess;

    public CountryService(){
    }

    public Map<String, Country> getCountries() {
        return countries;
    }

    public String getOperationStatusMessage()
    {
        return operationStatusMessage;
    }

    public boolean isOperationSuccess(){
        return operationSuccess;
    }

    public Country getCountry(String countryName){
            return countries.get(countryName);
    }

    public int getCountryPopulation(String countryName){
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

    public void updateCountry(Country country){
        checkContainsCountry(country.getName());
        if(!operationSuccess)return;

        checkErrorCountryName(country.getName());
        if(!operationSuccess)return;

        checkErrorCountryPopulation(country.getPopulation());
        if(!operationSuccess)return;

        countries.put(country.getName(), country);
    }

    public void deleteCountry(String countryName){
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


    public void checkCountryMapIsEmpty(){
        if(countries.isEmpty()){
            operationStatusMessage = errorCountryMapIsEmptyMessage();
            operationSuccess = false;
        }
        else{
            operationSuccess = true;
            operationStatusMessage = successfullOperationMessage();
        }
    }

    public void checkErrorCountryPopulation(int pop){
        operationSuccess = (pop > 0 && pop <= 2_000_000_000);
        if(!operationSuccess){
            operationStatusMessage = errorCountryPopulationMessage();
        }
        else{
            operationStatusMessage = successfullOperationMessage();}

    }

    public void checkErrorCountryName(String countryName){
        if (countryName.isEmpty() || !countryName.chars().allMatch(Character::isLetter)){
            operationSuccess = false;
            operationStatusMessage = errorCountryNameMessage();
        }
        else{
            operationSuccess = true;
            operationStatusMessage = successfullOperationMessage();
        }
    }

    public void checkContainsCountry(String countryName){
        if(countries.containsKey(countryName)){
            operationSuccess = true;
            operationStatusMessage = successfullOperationMessage();
        }
        else{
            operationStatusMessage = errorCountryNotContainsMessage();
            operationSuccess = false;
        }
    }

    public void checkNotContainsCountry(String countryName){
        if(!countries.containsKey(countryName)){
            operationSuccess = true;
            operationStatusMessage = successfullOperationMessage();
        }
        else{
            operationStatusMessage = errorCountryContainsMessage();
            operationSuccess = false;
        }
    }




}
