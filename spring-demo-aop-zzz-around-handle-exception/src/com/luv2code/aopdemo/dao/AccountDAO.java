package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass()+": add account");
	}
	
	public void doWork() {
		System.out.println(getClass()+": doWork");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccounts(boolean throwException){
		if(throwException)
			throw new RuntimeException("my excep");
		
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("Jhon","Silver");
		Account temp2 = new Account("Snow","Gold");
		Account temp3 = new Account("Frost","Platinum");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
				
		return myAccounts;
		
	}
}
