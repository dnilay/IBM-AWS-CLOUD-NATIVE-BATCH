package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.repo.CityRepository;
import com.example.demo.repo.CountryRepository;

@RestController
public class CountryController {
	private CountryRepository countryRepository;
	private CityRepository cityRepository;

	@Autowired
	public CountryController(CountryRepository countryRepository, CityRepository cityRepository) {
		super();
		this.countryRepository = countryRepository;
		this.cityRepository = cityRepository;
	}

	@PostMapping("/countries")
	public ResponseEntity<Country> createCountry(@RequestBody Country country,@RequestParam("id") Integer id,@RequestParam("name")String name) {
		List<City> cities=new ArrayList<City>();
		City city=new City(id, name);
		cities.add(city);
		country.setCities(cities);
		cityRepository.saveAll(cities);
		return ResponseEntity.ok(countryRepository.save(country));
	}
}
