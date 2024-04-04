package com.vipin.algorithm.basic;

public class MethodOverridingExperiment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class PQ {
	void doSomething() {

	}
}

class RS extends PQ {
	//String doSomething() { --> Compile time error
	void doSomething() {
		
	}
}

class TU extends RS {
	void doSomething() {

	}
}