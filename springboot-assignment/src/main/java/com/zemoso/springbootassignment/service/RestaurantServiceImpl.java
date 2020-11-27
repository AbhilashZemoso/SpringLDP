package com.zemoso.springbootassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.zemoso.springbootassignment.dao.RestaurantRepository;
import com.zemoso.springbootassignment.entity.Restaurant;
import com.zemoso.springbootassignment.entity.Review;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	private RestaurantRepository restaurantRepository;
	
	@Autowired
	public RestaurantServiceImpl(RestaurantRepository theRestaurantRepository) {
		restaurantRepository = theRestaurantRepository;
	}
	
	@Override
	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}
	
	@Override
	public List<Restaurant> findAllByOrderByNameAsc() {
		return restaurantRepository.findAllByOrderByNameAsc();
	}
	
	@Override
	public List<Restaurant> findAllByOrderByCityAsc() {
		return restaurantRepository.findAllByOrderByCityAsc();
	}
	
	@Override
	public List<Restaurant> findAllByOrderByRatingDesc() {
		return restaurantRepository.findAllByOrderByRatingDesc();
	}
	

	@Override
	public Restaurant findById(int theId) {
		Optional<Restaurant> result = restaurantRepository.findById(theId);
		Restaurant theRestaurant = null;
		if(result.isPresent())
			theRestaurant = result.get();
		else {
			throw new RuntimeException("Restaurant not found - "+ theId);
		}
		return theRestaurant;
	}

	@Override
	public void save(Restaurant theRestaurant) {
		restaurantRepository.save(theRestaurant);
	}

	@Override
	public void deleteById(int theId) {
		restaurantRepository.deleteById(theId);
	}

	@Override
	public List<Restaurant> searchBy(String theName) {
		
		List<Restaurant> results;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = restaurantRepository.findByNameContainsOrCityContainsAllIgnoreCase(theName, theName);
		}
		else {
			results = findAll();
		}
		
		return results;
	}
	
	@Override
	public String getUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return username;
	}

	@Override
	public List<Review> findAllReviews(int theId) {
		Restaurant theRestaurant = findById(theId);
		List<Review> reviews = theRestaurant.getReviews();
		return reviews;
	}

	@Override
	public void addReview(Review theReview) {
		int theId = theReview.getRestaurant_id();
		Restaurant theRestaurant = findById(theId);
		theRestaurant.addReview(theReview);
		save(theRestaurant);		
	}

	@Override
	public String getRestaurantName(int theId) {
		Restaurant theRestaurant = findById(theId);
		String name = theRestaurant.getName();
		return name;
	}
	
}






