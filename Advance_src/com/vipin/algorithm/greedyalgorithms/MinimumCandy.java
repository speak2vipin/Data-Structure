package com.vipin.algorithm.greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumCandy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[] = {1,2,87,87,87,2,1};
		ArrayList<Integer> A = new ArrayList<Integer> ();
		for(int temp :x) {
			A.add(temp);
		}
		System.out.println(candy(A));
		
		int c[] = {1,2,87,87,87,2,1};
		System.out.println(candy(c));
	}
	
	public static int candy(ArrayList<Integer> A) {
        int count = 0;
        int size = A.size();
        int PrefixCandies[] = new int[size];
        int SuffixCandies[] = new int[size];
        for(int i=0; i<size; i++) {
            PrefixCandies[i] = 1;
            SuffixCandies[i] = 1;
        }
        // PrefixCandies
        for(int i=1; i<size; i++) {
            if(A.get(i)>A.get(i-1) && PrefixCandies[i]<=PrefixCandies[i-1]) {
            	PrefixCandies[i] = PrefixCandies[i-1]+1;
            }
        }
        // SuffixCandies
        for(int i=size-2; i>-1; i--) {
            if(A.get(i)>A.get(i+1) && SuffixCandies[i]<=SuffixCandies[i+1]) {
                SuffixCandies[i] = SuffixCandies[i+1]+1;
            }
        }
        // Take Maximum of PrefixCandies and SuffixCandies so fullfill the condition 
        // for both sides of having maximum candies
        for(int i=0; i<size; i++) {
            count += Math.max(PrefixCandies[i], SuffixCandies[i]);
        }
        return count;
    }
	
	public static int candy(int[] ratings) {
        // Greedy Algo [1,2,87,87,87,2,1]
        int candies = 0;
        int n = ratings.length;
        int prefixCandy[] = new int[n];
        int suffixCandy[] = new int[n];
        Arrays.fill(prefixCandy, 1);
        Arrays.fill(suffixCandy, 1);
        
        for(int i=1; i<n; i++) {
             if(ratings[i]>ratings[i-1] && prefixCandy[i]<=prefixCandy[i-1]) {
                prefixCandy[i] = prefixCandy[i-1]+1;
            }
        }
        for(int i=n-2; i>-1; i--) {
             if(ratings[i]>ratings[i+1] && suffixCandy[i]<=suffixCandy[i+1]) {
                suffixCandy[i] = suffixCandy[i+1]+1;
            }
        }
        // 1, 1, 1, 1, 2, 2, 1 
        // 1, 2, 2, 1, 1, 1, 1
        // 1, 2, 2, 1, 2, 2, 1
        // 1, 2, 87,87,87,2, 1
        // 1, 2, 3, 1, 1, 1, 1
        // 1, 1, 1, 1, 3, 2, 1 
        for(int i=0; i<n; i++) {
            candies += Math.max(prefixCandy[i], suffixCandy[i]);
        }
        return candies;
    }

}
