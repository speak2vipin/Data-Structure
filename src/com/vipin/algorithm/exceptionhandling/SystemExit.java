package com.vipin.algorithm.exceptionhandling;

public class SystemExit {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			int a = 100/0;
		} catch(Exception e) {
			System.out.println("In catch block");	
			
			//System.out.println("System.exit get invoked");
			System.exit(1);
			throw new Exception("Throw an Exception");
		}

	}

}
