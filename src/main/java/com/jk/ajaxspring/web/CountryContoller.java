package com.jk.ajaxspring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("/")
	public String home() {
		//Return the default home page.
		return "selector";
	}
		
	@RequestMapping(path = "/countries", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<Country> findCountries() {

		//Load all countries and return as JSON response.
		List<Country> countries = countryRepo.findAll();
		return countries;
	}
	
	@RequestMapping(path = "/states/{countryId}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	//@Query(value="select * from state where country_id = ?1")
	public List<State> getStatesByCountry(@PathVariable("countryId") Long countryId){
		
		//Load all states of given country and return as JSON response.
		List<State> states = stateRepo.findAllByCountry_countryId(countryId);
		return states;		
	}
	
	@RequestMapping(path = "/cities/{stateId}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	//@Query(value="select * from city where state_id = ?1")
	public List<City> getCitiesByState(@PathVariable("stateId") Long stateId){
		
		//Load all cities of given state and return as JSON response.
		List<City> cities = cityRepo.findAllByState_stateId(stateId);
		return cities;		
	}
	
}
