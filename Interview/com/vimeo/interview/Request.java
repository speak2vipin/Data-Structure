package com.vimeo.interview;

import java.util.Date;

public class Request {
	
	private Integer count;
	private Date time;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Request(Integer count, Date time) {
		super();
		this.count = count;
		this.time = time;
	}
	
	
	
	

}
