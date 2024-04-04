package com.vipin.algorithm.exceptionhandling;

public class ChildClassSuperClassInHierarchy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void print() {
		throw new IllegalArgumentException();
	}

	void sum() throws Exception {

	}

}

class temp extends ChildClassSuperClassInHierarchy {
	void sum() throws ArithmeticException {

	}
}
