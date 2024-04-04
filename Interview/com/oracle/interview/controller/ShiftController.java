package com.oracle.interview.controller;

import java.util.ArrayList;
import java.util.List;

import com.oracle.interview.schema.Request;
import com.oracle.interview.schema.Timing;
import com.oracle.interview.service.IShiftService;
import com.oracle.interview.service.ShiftService;

public class ShiftController implements Controller {

	@Override
	public String getShift() {
		
		
		Timing firstTiming = new Timing(8, 10);
		Timing secondTiming = new Timing(10, 12);
		Timing thirdTiming = new Timing(14, 19);
		List<Timing> timingList = new ArrayList<>();
		timingList.add(firstTiming);
		timingList.add(secondTiming);
		timingList.add(thirdTiming);
		
		Request request = new Request(100, timingList);
		
		
		IShiftService shiftService = new ShiftService();
		shiftService.getShiftMetaData()
		
		
		
		return null;
	}

}
