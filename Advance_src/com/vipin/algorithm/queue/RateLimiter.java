package com.vipin.algorithm.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class RateLimiter {
	
	private Long maxSize;
	private Long window;
	private final Queue<Long>requests;
	
	public RateLimiter(Long maxSize, Long window) {
		this.maxSize = maxSize;
		this.window = window;
		requests = new ArrayDeque<>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RateLimiter rateLimiter = new RateLimiter(100l, 36000l);
		for(int i=0; i<500; i++) {
			if(rateLimiter.isAllowed()) {
				
			} else {
				
			}
		}
		

	}

	boolean isAllowed() {
		Long currentTime = System.currentTimeMillis();
		Long currentWindow = currentTime - window;
		while(!requests.isEmpty() && requests.peek()< currentWindow) {
			requests.poll();
		}
		if(requests.size()<maxSize) {
			requests.offer(currentTime);
			return true;
		}
		return false ;
	}
}


