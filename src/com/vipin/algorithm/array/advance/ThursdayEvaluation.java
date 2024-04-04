package com.vipin.algorithm.array.advance;

public class ThursdayEvaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {9,6,0,0,5,0,-1,0};
		
		moveZeroToLeft(input);
		for(int i : input) {
			System.out.println(i);
		}
		
		moveZeroToRight(input);
		for(int i : input) {
			System.out.println(i);
		}
	}
	
	static void moveZeroToLeft(int input[]) {
		int n = input.length-1;
		int last = n;
		for(int i=n; i>-1; i--) {
			if(input[i]!=0) {
				input[last] = input[i];
				last--;
			}
		}
		while(last>-1) {
			input[last] = 0;
			last--;
		}
		
	}
	static void moveZeroToRight(int input[]) {
		int n = input.length;
		int start = 0;
		for(int i=0; i<n; i++) {
			if(input[i]!=0) {
				input[start] = input[i];
				start++;
			}
		}
		while(start<n) {
			input[start] = 0;
			start++;
		}
		
	}
	
	

}
