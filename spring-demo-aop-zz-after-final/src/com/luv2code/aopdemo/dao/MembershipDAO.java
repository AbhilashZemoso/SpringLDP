package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass()+" : add Account");
	}
	
	public boolean addSilly() {
		System.out.println(getClass()+" : add Silly");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass()+" : go to sleep");
	}
	
}
