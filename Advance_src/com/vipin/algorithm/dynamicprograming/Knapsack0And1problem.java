package com.vipin.algorithm.dynamicprograming;

import java.util.ArrayList;

public class Knapsack0And1problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer> ();
		A.add(359);A.add(963); A.add(465); A.add(706); A.add(146); A.add(282); A.add(828); A.add(962); A.add(492);
		ArrayList<Integer> B = new ArrayList<Integer> ();
		B.add(96);B.add(43); B.add(28); B.add(37); B.add(92); B.add(5); B.add(3); B.add(54);B.add(93);
		
		Knapsack0And1problem k = new Knapsack0And1problem();
		System.out.println(k.solve(A, B, 383));

	}
	
	public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int x = B.size();
        int y = C;
        int dp[][] = new int[x+1][y+1];
        
        for(int i=1; i<x+1; i++) {
            //int tempC = C; 
            for(int j=1; j<y+1; j++) {
                if(j>=B.get(i-1)) {
                    dp[i][j] = Math.max(dp[i-1][j], A.get(i-1)+dp[i-1][j- B.get(i-1)]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }      
            }
        }
        return dp[x][y];

    }

}
