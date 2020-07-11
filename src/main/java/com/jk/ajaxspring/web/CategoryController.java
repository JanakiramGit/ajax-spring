package com.jk.ajaxspring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.ajaxspring.model.Category;
import com.jk.ajaxspring.model.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepo;

	@GetMapping("/index")
	public String home() {
		//Return the default home page.
		return "index";
	}

	@RequestMapping(path = "/listajax", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<Category> findCities() {

		//Load all cities and return as JSON response.
		List<Category> cities = categoryRepo.findAll();
		return cities;
	}
	
}
