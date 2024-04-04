package com.oracle.interview.service;

import java.util.List;

import com.oracle.interview.schema.Request;
import com.oracle.interview.schema.Shift;
import com.oracle.interview.schema.Timing;

public class ShiftService implements IShiftService {

	public List<Timing> getShiftMetaData(Request request) {
		List<Timing> userTiming = null;
		
			if(request!=null && request.getTimings()!=null) {
				
			}
			
		return userTiming;
	}
	
}


