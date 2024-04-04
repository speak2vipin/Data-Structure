package com.vipin.java8.lamda;

public class CheckEnumComparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Status.NEW==Status.OLD);
		System.out.println(Status.NEW==null);
		System.out.println(null==Status.OLD);
		System.out.println(Status.NEW==Status.NEW);
		System.out.println(null==null);
	}

}


enum Status {
	NEW, OLD
}
