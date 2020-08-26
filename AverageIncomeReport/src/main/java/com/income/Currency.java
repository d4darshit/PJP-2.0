package com.income;

public enum Currency {


	USD(1),
	INR(66f),
	GBP(0.67f),
	SGD(1.5f),
	HKD(8f);
	
	private float conversionRate;
	
	public float getConversionRate() {
	    return conversionRate;
	  }
	Currency(float conversion) {
	    this.conversionRate = conversion;
	  }
}
