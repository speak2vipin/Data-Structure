package com.vipin.algorithm.basic;

public class AbstractClassIntantiation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TempNew t = new AbstractClass();
		//System.out.println(t.x);
	}

}

class AbstractClass extends TempNew {
	//TempNew t = new AbstractClass();
	static int x = 101;
	
}

abstract class TempNew {
	//static int x = 10;
}
