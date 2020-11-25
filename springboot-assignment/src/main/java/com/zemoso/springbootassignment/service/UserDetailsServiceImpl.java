package com.zemoso.springbootassignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.springbootassignment.dao.UserDetailsDAO;
import com.zemoso.springbootassignment.entity.UserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDetailsDAO userDetailsDAO;

	@Override
	public void save(UserDetails theUser) {
		userDetailsDAO.save(theUser);
	}
}
