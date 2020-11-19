package com.zemoso.springbootassignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zemoso.springbootassignment.entity.Restaurant;
import com.zemoso.springbootassignment.service.RestaurantService;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

	private RestaurantService restaurantService;
	
	public RestaurantController(RestaurantService theRestaurantService) {
		restaurantService = theRestaurantService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listRestaurants(@RequestParam(required = false) String orderBy,Model theModel) {
		
		List<Restaurant> theRestaurants=null;
		if(orderBy==null) {
			theRestaurants = restaurantService.findAll();
		}
		else if(orderBy.equals("name")){
			theRestaurants = restaurantService.findAllByOrderByNameAsc();
		}
		else if(orderBy.equals("city")){
			theRestaurants = restaurantService.findAllByOrderByCityAsc();
		}
		// add to the spring model
		theModel.addAttribute("restaurants", theRestaurants);
		
		return "restaurants/list-restaurants";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Restaurant theRestaurant = new Restaurant();
		
		theModel.addAttribute("restaurant", theRestaurant);
		
		return "restaurants/restaurant-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("restaurantId") int theId,
									Model theModel) {
		
		// get the restaurant from the service
		Restaurant theRestaurant = restaurantService.findById(theId);
		
		// set restaurant as a model attribute to pre-populate the form
		theModel.addAttribute("restaurant", theRestaurant);
		
		// send over to our form
		return "restaurants/restaurant-form";			
	}
	
	
	@PostMapping("/save")
	public String saveRestaurant(
			@Valid @ModelAttribute("restaurant") Restaurant theRestaurant,
			BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()) {
			return "restaurants/restaurant-form";
		}
		// save the restaurant
		restaurantService.save(theRestaurant);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/restaurants/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("restaurantId") int theId) {
		
		restaurantService.deleteById(theId);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/restaurants/list";
	}
	
	
}












