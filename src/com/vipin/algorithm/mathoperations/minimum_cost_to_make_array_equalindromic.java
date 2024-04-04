package com.vipin.algorithm.mathoperations;

public class minimum_cost_to_make_array_equalindromic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num[] = {101,102,103};
		System.out.println(minimumCost(num));

	}
	
	 public static  long minimumCost(int[] nums) {
	        long sum = 0l;
	        int n = nums.length;
	        for(int num : nums) {
	            sum+=num;
	        }
	        long avg = sum/n;
	        String temp = avg+"";
	        int N = temp.length();
	        int index = temp.charAt(0)-'0';
	        String palindrome1 = "";
	        String palindrome2 = "";
	        for(int i=0; i<N; i++) {
	            palindrome1 += index;
	        }
	        for(int i=0; i<N; i++) {
	            palindrome2 += (index+1);
	        }
	        StringBuilder palindrome3 = new StringBuilder();
	        if((N%2)==0) {
	            palindrome3.append(temp.substring(0, (N/2)));
	            palindrome3.append(palindrome3.reverse());
	        } else {
	            int half = N/2;
	            StringBuilder palindrome4 = new StringBuilder(temp.substring(0, half));
	            palindrome3.append(palindrome4).append(temp.substring(half, half+1));
	            palindrome3.append(palindrome4.reverse());
	        }
	        StringBuilder palindrome4 = new StringBuilder();
	        if((N%2)==0) {
	            palindrome3.append(temp.substring((N/2)));
	            palindrome3.append(palindrome3.reverse());
	        } else {
	            int half = N/2;
	            StringBuilder palindrome5 = new StringBuilder(temp.substring(half+1));
	            palindrome4.append(temp.substring(half, half+1)).append(palindrome5);
	            palindrome4 = palindrome5.reverse().append(palindrome4);
	        }
	       
	        long sum1 = calculateCost(nums, palindrome1);
	        long sum2 = calculateCost(nums, palindrome2);
	        long sum3 = calculateCost(nums, palindrome3.toString());
	        long sum4 = calculateCost(nums, palindrome4.toString());
	        return Math.min(Math.min(sum3, sum4), Math.min(sum1, sum2));
	    }
	    
	    static long calculateCost(int nums[], String palindrome) {
	        long sum = 0l;
	        long p = Long.parseLong(palindrome);
	        for(int num : nums) {
	            sum += Math.abs(p-num);
	        }
	        return sum;
	    }

}
