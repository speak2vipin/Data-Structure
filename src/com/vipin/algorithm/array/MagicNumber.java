package com.vipin.algorithm.array;

public class MagicNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MagicNumber m = new MagicNumber();
		System.out.println(m.solve(10));
	}

	
		public int solve(int A) {
			if(A == 0){
	            return 5;
	        }
	        int ans = 0;
	        int mul = 1;
	        int reminder = 0;
	        while(A > 0){
	            reminder = A % 2;
	            ans += (int)Math.pow(5 * reminder, mul);
	            mul++;
	            A /= 2;
	            System.out.println(ans);
	        }
			return ans;
		}
	

}
