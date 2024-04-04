package com.vimeo.interview;

public class RateLimitor {
	
	String URL;
	Integer noOfRequest;
	Integer rate;
	Unit unit;
	
	public RateLimitor(String uRL, Integer noOfRequest, Integer rate, Unit unit) {
		super();
		URL = uRL;
		this.noOfRequest = noOfRequest;
		this.rate = rate;
		this.unit = unit;
	}
	
	

}
