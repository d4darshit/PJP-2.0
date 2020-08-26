package com.income;

public enum Gender {

	M("M"),
	F("F");
	private String genderValue;
	
	public String getGenderValue() {
		return genderValue;
	}
	Gender(String string){
		this.genderValue = string;
	}
}
