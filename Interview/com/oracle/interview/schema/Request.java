package com.oracle.interview.schema;

import java.util.List;

public class Request {

	private int userId;
	private List<Timing> timings;
	
	

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(int userId, List<Timing> timings) {
		super();
		this.userId = userId;
		this.timings = timings;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Timing> getTimings() {
		return timings;
	}

	public void setTimings(List<Timing> timings) {
		this.timings = timings;
	}

}
