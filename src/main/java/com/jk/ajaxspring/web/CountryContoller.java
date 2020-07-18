package com.jk.ajaxspring.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jk.ajaxspring.model.City;
import com.jk.ajaxspring.model.CityRepository;
import com.jk.ajaxspring.model.Country;
import com.jk.ajaxspring.model.CountryRepository;
import com.jk.ajaxspring.model.State;
import com.jk.ajaxspring.model.StateRepository;

@Controller
public class CountryContoller {
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@RequestMapping(path = "/")	
	public String home() {
		//Return the default home page.
		return "selector";
	}
		
	@GetMapping("/countries")
	public ResponseEntity<List<Country>> findAllCountries() {

		//Load all countries and return as JSON response.
		List<Country> countries = countryRepo.findAll();
		return new ResponseEntity<>(countries, HttpStatus.OK);
	}	
	
	//@RequestMapping(path = "/countries/{countryId}" produces = "application/json; charset=UTF-8")
	@GetMapping("/countries/{countryId}")	
	public ResponseEntity<Optional> findCountryById(@PathVariable("countryId") Long countryId) {

		//Load Country with the given Id and return as JSON response.
		Optional<Country> country = countryRepo.findById(countryId);
		return new ResponseEntity<Optional>(country, HttpStatus.OK);
	}

	@GetMapping("/states/{countryId}")	
	public ResponseEntity<List> getStatesByCountry(@PathVariable("countryId") Long countryId){
		
		//Load all states of given country and return as JSON response.
		List<State> states = stateRepo.findAllByCountry_countryId(countryId);
		return new ResponseEntity<List>(states, HttpStatus.OK);
	}
	
	@GetMapping("/cities/{stateId}")
	//@Query(value="select * from city where state_id = ?1")
	public ResponseEntity<List> getCitiesByState(@PathVariable("stateId") Long stateId){
		
		//Load all cities of given state and return as JSON response.
		List<City> cities = cityRepo.findAllByState_stateId(stateId);
		return new ResponseEntity<List>(cities, HttpStatus.OK);		
	}
	
}
