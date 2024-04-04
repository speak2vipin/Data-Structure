package com.vipin.algorithm.basic;

public class InheritanceExample {
public static void main(String[] args) {
	D d = new D();
}
}

class A {
	//A() {
		//System.out.println("In A");
	//}
	A(String paramter) {
		System.out.println("In A " + paramter);
	}

}

class B extends A {
	B() {
		super("Super");
		System.out.println("In B");
	}
	
}

class C extends B {
	C() {
		System.out.println("In C");
	}
}

class D extends C{
	D() {
		System.out.println("In D");
	}
}
