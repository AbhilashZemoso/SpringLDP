package learningDemo;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class Student {
	private String name;
	private String language;
	private String country;
	private String operatingSystems[];
	
	private LinkedHashMap<String,String> countryOptions;

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public Student() {
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("IN", "India");
		countryOptions.put("DE", "Germany");
		countryOptions.put("FR", "France");
		countryOptions.put("US", "Unites States");
	}
	
	public Student(String name, String language, String country, String[] operatingSystems) {
		this.name = name;
		this.language = language;
		this.country = country;
		this.operatingSystems = operatingSystems;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", language=" + language + ", country=" + country + ", operatingSystems="
				+ Arrays.toString(operatingSystems) + "]";
	}
}
