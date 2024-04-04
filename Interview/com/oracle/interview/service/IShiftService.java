package com.oracle.interview.service;

import java.util.List;

import com.oracle.interview.schema.Request;
import com.oracle.interview.schema.Shift;

public interface IShiftService {
	
	public List<Shift> getShiftMetaData(Request request);

}
