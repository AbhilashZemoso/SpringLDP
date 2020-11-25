package com.zemoso.springbootassignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	@Pattern(regexp = "^[a-zA-Z,0-9 ]*$", message="must not contain special characters")
	@Column(name="city")
	private String city;
	
	@Column(name="website")
	@Pattern(regexp="[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)",
			message="not a valid website")
	private String website;
	
	@Size(min=0,max=200,message="upto {max} characters are allowed")
	@Column(name="details")
	private String details;
	
	@Min(1)
	@Max(10)
	@Column(name="rating")
	private float rating;
	
		
	// define constructors
	
	public Restaurant() {
		
	}
	

	public Restaurant(int id, @Valid @NotEmpty(message = "is required") String name,
			@NotEmpty(message = "is required") @Pattern(regexp = "^[a-zA-Z ]*$", message = "must contain only alphabets") String city,
			String website, @Size(min = 0, max = 200, message = "upto {max} characters are allowed") String details,
			@NotEmpty(message = "is required") int rating) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.website = website;
		this.details = details;
		this.rating = rating;
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


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", city=" + city + ", website=" + website + ", details="
				+ details + ", rating=" + rating + "]";
	}
}











