package com.example.Module22;

import com.example.Module22.model.Country;
import com.example.Module22.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class Module22ApplicationTests {

	private final String errorCountryNameMessage = "Страны с таким названием не может существовать!";
	private final String errorCountryMapIsEmptyMessage = "Список стран пуст!";
	private final String errorCountryNotContainsMessage = "Страны с таким названием не сущестувет в списке!";
	private final String errorCountryPopulationMessage = "Страны с таким количеством населения не может существовать!";
	private final String errorCountryContainsMessage = "Страна с таким названием уже существует в списке!";
	private final String successfullOperationMessage = "Операция выполнена успешно";

	@InjectMocks
	private CountryService countryService = new CountryService();

	@BeforeEach
	public void beforeEachTest(){
		countryService.getCountries().clear();
	}

	@Test
	public void testGetCountries(){
		countryService.checkCountryMapIsEmpty();
		assertEquals(countryService.isOperationSuccess(), false);
		assertEquals(countryService.getOperationStatusMessage(),errorCountryMapIsEmptyMessage );
	}

	@Test
	public void testGetCountry(){
		Country country = new Country("USA", 300);

		countryService.checkContainsCountry(country.getName());
		assertEquals(countryService.isOperationSuccess(), false);
		assertEquals(countryService.getOperationStatusMessage(), errorCountryNotContainsMessage);

		countryService.setNewCountry(country);
		Country countryOtvet = countryService.getCountry(country.getName());
		assertEquals(countryService.isOperationSuccess(), true);
		assertEquals(countryService.getOperationStatusMessage(), successfullOperationMessage);
	}

	@Test
	public void testGetCountryPopulation(){
		Country country = new Country("USA", 300);

		countryService.checkContainsCountry(country.getName());
		assertEquals(countryService.isOperationSuccess(), false);
		assertEquals(countryService.getOperationStatusMessage(), errorCountryNotContainsMessage);

		countryService.setNewCountry(country);
		int otvet = countryService.getCountryPopulation(country.getName());
		assertEquals(countryService.isOperationSuccess(), true);
		assertEquals(countryService.getOperationStatusMessage(), successfullOperationMessage);
		assertEquals(otvet, 300);
	}
	@Test
	public void testSetNewCountry(){
		countryService.setNewCountry(new Country("USA1", 300));
		assertEquals(countryService.isOperationSuccess(), false);
		assertEquals(countryService.getOperationStatusMessage(), errorCountryNameMessage);

		countryService.setNewCountry(new Country("USA", -300));
		assertEquals(countryService.isOperationSuccess(), false);
		assertEquals(countryService.getOperationStatusMessage(), errorCountryPopulationMessage);

		countryService.setNewCountry(new Country("USA", 300));
		assertEquals(countryService.isOperationSuccess(), true);
		assertEquals(countryService.getOperationStatusMessage(), successfullOperationMessage);

		countryService.setNewCountry(new Country("USA", 300));
		assertEquals(countryService.isOperationSuccess(), false);
		assertEquals(countryService.getOperationStatusMessage(), errorCountryContainsMessage);
	}

	@Test
	public void testUpdateCountry(){
		countryService.setNewCountry(new Country("USA", 300));

		countryService.updateCountry(new Country("Russia", 250));
		assertEquals(countryService.isOperationSuccess(), false);
		assertEquals(countryService.getOperationStatusMessage(), errorCountryNotContainsMessage);

		countryService.updateCountry(new Country("USA", -300));
		assertEquals(countryService.isOperationSuccess(), false);
		assertEquals(countryService.getOperationStatusMessage(), errorCountryPopulationMessage);

		countryService.updateCountry(new Country("USA", 300));
		assertEquals(countryService.isOperationSuccess(), true);
		assertEquals(countryService.getOperationStatusMessage(), successfullOperationMessage);

		countryService.updateCountry(new Country("USA1", 300));
		assertEquals(countryService.isOperationSuccess(), false);
		assertEquals(countryService.getOperationStatusMessage(), errorCountryNotContainsMessage);
	}

	@Test
	public void testDeleteCountry(){
		countryService.setNewCountry(new Country("USA", 300));

		countryService.deleteCountry("usa");
		assertEquals(countryService.isOperationSuccess(), false);
		assertEquals(countryService.getOperationStatusMessage(), errorCountryNotContainsMessage);

		countryService.deleteCountry("USA");
		assertEquals(countryService.isOperationSuccess(), true);
		assertEquals(countryService.getOperationStatusMessage(), successfullOperationMessage);

	}

}
