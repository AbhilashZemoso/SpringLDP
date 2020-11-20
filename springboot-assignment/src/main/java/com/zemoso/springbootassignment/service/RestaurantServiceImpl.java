package com.zemoso.springbootassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.springbootassignment.dao.RestaurantRepository;
import com.zemoso.springbootassignment.entity.Restaurant;

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
		
		List<Restaurant> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = restaurantRepository.findByNameContainsOrCityContainsAllIgnoreCase(theName, theName);
		}
		else {
			results = findAll();
		}
		
		return results;
	}
}





