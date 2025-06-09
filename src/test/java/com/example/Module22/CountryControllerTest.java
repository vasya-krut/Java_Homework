package com.example.Module22;

import com.example.Module22.controller.CountryController;
import com.example.Module22.model.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class CountryControllerTest {

	private final String errorCountryNameMessage = "Страны с таким названием не может существовать!";
	private final String errorCountryMapIsEmptyMessage = "Список стран пуст!";
	private final String errorCountryNotContainsMessage = "Страны с таким названием не сущестувет в списке!";
	private final String errorCountryPopulationMessage = "Страны с таким количеством населения не может существовать!";
	private final String errorCountryContainsMessage = "Страна с таким названием уже существует в списке!";
	private final String successfullOperationMessage = "Операция выполнена успешно";

	@InjectMocks
	private CountryController countryController = new CountryController();

	Country testCountry = new Country("USA", 300);

	@BeforeEach
	public void beforeEachTest(){
		countryController.getCountries().clear();
	}

	@Test
	public void testGetAllCountries(){
		assertEquals(countryController.getAllCountries(), ResponseEntity.ok(errorCountryMapIsEmptyMessage));
		countryController.setNewCountry(testCountry);
		assertEquals(countryController.getAllCountries(), new ResponseEntity<>(countryController.getCountries(), HttpStatus.OK));
	}

	@Test
	public void testGetCountryByName(){
		assertEquals(countryController.getCountryByName("USA"), ResponseEntity.ok(errorCountryNotContainsMessage));
		countryController.setNewCountry(testCountry);
		assertEquals(countryController.getCountryByName("USA"), new ResponseEntity<>(testCountry, HttpStatus.OK));
	}

	@Test
	public void testGetPopulationByCountryName(){
		assertEquals(countryController.getPopulationByCountryName("USA"), ResponseEntity.ok(errorCountryNotContainsMessage));
		countryController.setNewCountry(testCountry);
		assertEquals(countryController.getPopulationByCountryName("USA"), new ResponseEntity<>(testCountry.getPopulation(), HttpStatus.OK));
	}

	@Test
	public void testSaveCountry(){
		assertEquals(countryController.saveCountry(new Country("USA1", 300)), ResponseEntity.ok(errorCountryNameMessage));
		assertEquals(countryController.saveCountry(new Country("USA", -300)), ResponseEntity.ok(errorCountryPopulationMessage));
		assertEquals(countryController.saveCountry(testCountry), new ResponseEntity<>(testCountry, HttpStatus.CREATED));
		assertEquals(countryController.saveCountry(testCountry), ResponseEntity.ok(errorCountryContainsMessage));
	}

	@Test
	public void testUpdateCountry(){
		countryController.setNewCountry(testCountry);
		assertEquals(countryController.updateCountry(new Country("Russia", 145)), ResponseEntity.ok(errorCountryNotContainsMessage));
		assertEquals(countryController.updateCountry(new Country("USA", -300)), ResponseEntity.ok(errorCountryPopulationMessage));
		Country testCountryUpdate = new Country("USA", 145);
		assertEquals(countryController.updateCountry(testCountryUpdate), new ResponseEntity<>(testCountryUpdate, HttpStatus.CREATED));
		assertEquals(countryController.updateCountry(new Country("USA!", 300)), ResponseEntity.ok(errorCountryNotContainsMessage));
	}

	@Test
	public void testDeleteCountryByName(){
		countryController.setNewCountry(testCountry);
		assertEquals(countryController.deleteCountryByName("usa"), ResponseEntity.ok(errorCountryNotContainsMessage));
		assertEquals(countryController.deleteCountryByName("USA"), ResponseEntity.ok( successfullOperationMessage));
	}

}
