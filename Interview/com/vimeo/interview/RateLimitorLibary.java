package com.vimeo.interview;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RateLimitorLibary {

	Map<String, RateLimitor> configMap = new HashMap<>();
	Map<String, List<Request>> requestMap = new HashMap<>();

	public void config(String URL, int noOfRequest, int rate, Unit unit) {
		configMap.put(URL, new RateLimitor(URL, noOfRequest, rate, unit));
	}

	public boolean isRateLimited(String URL) {
		try {
			cleanUp(URL);

			if (configMap.get(URL) != null) {
				RateLimitor rateLimitor = configMap.get(URL);
				int existingRequests = requestMap.get(URL) == null ? 0 : requestMap.get(URL).size();
				
				requestMap.computeIfAbsent(URL, val -> new ArrayList<Request>()).add(new Request(0, new Date()));
				if (existingRequests > rateLimitor.noOfRequest) {
					return true;
				}
			}
		} catch (Exception ex) {

		}
		return false;
	}

	private void cleanUp(String URL) {
		RateLimitor rateLimitor = configMap.get(URL);
		if (isWindowExpired(URL)) {
			requestMap.remove(URL);
		}
	}

	// Calculating requests belong to the existing window
	// if Yes return false;
	// else return true;
	private boolean isWindowExpired(String URL) {
		return false;
	}

}
