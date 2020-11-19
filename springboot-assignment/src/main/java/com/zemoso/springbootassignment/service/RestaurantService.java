package com.zemoso.springbootassignment.service;

import java.util.List;

import com.zemoso.springbootassignment.entity.Restaurant;

public interface RestaurantService {
	
	public List<Restaurant> findAll();
	
	public Restaurant findById(int theId);
	
	public void save(Restaurant theRestaurant);
	
	public void deleteById(int theId);
}
