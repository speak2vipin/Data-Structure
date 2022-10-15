package com.vipin.algorithm.basicmath;

import java.math.BigDecimal;

public class MathsAbsoluteFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.abs(Double.parseDouble("-100")));
		System.out.println(Math.abs(Double.parseDouble("-100.40")));
		System.out.println(new BigDecimal(Math.abs(new Double(100.10))));
		System.out.println(new BigDecimal(Math.abs(new Float(100.10))));
		
	}

}
