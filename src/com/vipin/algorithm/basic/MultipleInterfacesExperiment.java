package com.vipin.algorithm.basic;

public class MultipleInterfacesExperiment  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		One one = new Three();
		one.print();
		Two two = new Three();
		two.print();
		// Will print Overridden method of Three class
		
	}
	

}

interface One {
	void print();
}
interface Two {
	default void print() {
		System.out.println("in Two default print method");
	}
}

class Three implements One, Two {

	@Override
	public void print() {
		System.out.println("In Three print method");
		
	}
	
}
