package com.income;

public class Income {

	private String city;
	private String country;
	private Gender gender;
	private Currency currency;
	private float amount;
	private String location;
	
	public Income(String city, String country, Gender gender, Currency currency, Float amount) {
		
		this.city = city;
		this.country = country;
		this.gender = gender;
		this.currency = currency;
		this.amount = amount;
		if(country==null)
			this.setLocation(city);
		else
			this.setLocation(country);  
		
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Currency getCurrency() {
		return this.currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public float getAmount() {
		
		return this.amount/currency.getConversionRate();
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender.getGenderValue();
	}
	@Override
	public String toString() {
		return "Income [city=" + city + ", country=" + country + ", gender=" + gender + ", Currency=" + currency
				+ ", Amount=" + amount + "]";
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}

