package com.vipin.algorithm.basic;

public class MethodOverloadingExperiment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AB a = new AB();
		a.print(0);
		//a.print(null);				---> For null compiler will get ambigous to call which method
		a.print(new Integer(0));
		a.print("In Main method");
		a.print(a);
		
	}

}

class AB {
	void print(int a) {
		System.out.println("int " + a);
	}
	//static void print() {
		
	//}
	
	void print(Integer a) {
		System.out.println("Integer " + a);
	}
	
	void print(Object o) {
		System.out.println("Object " + o);
	}
	
	//void print(String s) {
		//System.out.println("String " + s);
	//}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("toString()");
		return super.toString();
	}
	
}
