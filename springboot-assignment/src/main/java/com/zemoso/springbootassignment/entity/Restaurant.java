package com.zemoso.springbootassignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="restaurant")
public class Restaurant {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Valid
	@NotEmpty(message="is required")
	@Column(name="name")
	private String name;
	
	@NotEmpty(message="is required")
	@Pattern(regexp = "^[a-zA-Z ]*$", message="must contain only alphabets")
	@Column(name="city")
	private String city;
	
	@Column(name="website")
	private String website;
	
	@Size(min=0,max=200,message="upto {max} characters are allowed")
	@Column(name="details")
	private String details;
	
		
	// define constructors
	
	public Restaurant() {
		
	}

	public Restaurant(int id, String name, String city, String website, String details) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.website = website;
		this.details = details;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", city=" + city + ", website=" + website + ", details="
				+ details + "]";
	}	
}











