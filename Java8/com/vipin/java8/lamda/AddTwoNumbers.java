package com.vipin.java8.lamda;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Addable A = (a, b) -> (a+b);
		System.out.println(A.sum(8, 7));
	}
	
	
	
	

}
interface Addable {
	int sum(int a, int b);
}
