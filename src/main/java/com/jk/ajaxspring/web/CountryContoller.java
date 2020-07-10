package com.jk.ajaxspring.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("/selector")
	public String home() {
		//Return the default home page.
		return "selector";
	}
		
	@RequestMapping(path = "/countries", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<Country> findCountries() {

		//Load all cities and return as JSON response.
		List<Country> countries = countryRepo.findAll();
		return countries;
	}

//	@RequestMapping(path = "/states", produces = "application/json; charset=UTF-8")
//	@ResponseBody
//	public List<State> findStates() {
//
//		//Load all cities and return as JSON response.
//		List<State> states = stateRepo.findAll();
//		return states;
//	}
	
	
	@RequestMapping(path = "/states/{countryId}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Optional<State> findStates(@PathVariable("countryId") Long countryId) {

		//Load all cities and return as JSON response.
		Optional<State> states = stateRepo.findById(countryId);
		return states;
	}
}
