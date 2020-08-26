package com.income;

public class Summary {

	private String location;
	private Gender gender;
	private Double averageAmount;
	public Summary(String location, Gender gender, Double amount) {
		this.location = location;
		this.gender = gender;
		this.averageAmount = amount;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Double getAverageAmount() {
		return averageAmount;
	}
	public void setAverageAmount(Double averageAmount) {
		this.averageAmount = averageAmount;
	}
	@Override
	public String toString() {
		return "Summary [location=" + location + ", gender=" + gender + ", averageAmount=" + averageAmount + "]";
	}
	@Override
	public boolean equals(Object obj) {

		// Change this section
		return true;
				
	}
	
	
}
