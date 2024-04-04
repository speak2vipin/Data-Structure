package com.vipin.algorithm.basic;

public class OverloadingStaticMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class StaticClass {
	 void print() {
		
	}
	
}

class DerivedStaticClass extends StaticClass {
	//public static void print() {
	void print() {
		// Static method can't hide print method of StaticClass resulting we will get compile time error.
		
	}
}


