package com.vipin.algorithm.binarysearch;

public class EqualCandyToKids {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[]candies = {10000000,10000000,10000000};
		long k = 1000000000000l;
		EqualCandyToKids e = new EqualCandyToKids();
		System.out.println(e.maximumCandies(candies, k));

	}

	public int maximumCandies(int[] candies, long k) {

		long high = candies[0];
		long low = 0;
		for (int candy : candies) {
			high = Math.max(candy, high);
		}

		high = 10_000_000;
		long mid = 0;

		while (low < high) {
			mid = (low + high + 1) / 2;
			if (isPossible(candies, k, mid)) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		return (int) low;
	}

	boolean isPossible(int candies[], long k, long temp) {
		long count = 0;
		for (int candy : candies) {
			count += ((long) candy / temp);
		}
		return count >= k;
	}

}
