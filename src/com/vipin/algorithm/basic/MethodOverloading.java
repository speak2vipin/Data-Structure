package com.vipin.algorithm.basic;

public class MethodOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Temp t = new Temp();
		System.out.println(t.getName("Shiva"));

	}

}

class Temp {
	String getName(String name) {
		return "Ram";
	}
	
	Object getName(Object name) {
		return "sita";
	}
}
