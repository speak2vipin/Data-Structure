package com.vipin.algorithm.dynamicprograming;

import java.util.Arrays;
import java.util.*;

public class MaximumProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProduct m = new MaximumProduct();
		int A[] = { 2, -1, 10, 8 };
		System.out.println(m.maxProduct(A));
		int p[][] = { { 1, -3, 2 }, { 2, 5, 10 }, { 5, -5, 1} };
		//[[8, 7, 4], [9, 5, 2], [5, 6, 1]]
		System.out.println(m.minPathSum(p));
		
		int X[] = {4, 5, 12, 30};
		
		System.out.println(m.maxScore(X));

	}

	int dp[] = null;
	int N = 0;

	public int maxProduct(final int[] A) {
		N = A.length;
		dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		helper(A, 0);
		return dp[0];
	}

	int helper(int A[], int index) {
		if (index == N) {
			return 1;
		}
		if (dp[index] != Integer.MAX_VALUE) {
			return dp[index];
		}
		int val = Integer.MIN_VALUE;
		val = Math.max(val, A[index] * helper(A, index + 1));
		val = Math.max(val, helper(A, index + 1));
		return dp[index] = val;
	}

	public int minPathSum(int[][] A) {
		int N = A.length;
		int M = A[0].length;
		int dp[][] = new int[N][M];
		for (int j = M - 1; j >= 0; j--) {
			dp[N - 1][j] = A[N - 1][j];
		}
		for (int i = N - 2; i >= 0; i--) {
			for (int j = M-1; j >=0; j--) {
				if (j < M - 1)
					dp[i][j] = A[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
				else {
					dp[i][j] = A[i][j] + dp[i + 1][j];
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int j = M - 1; j >= 0; j--) {
			ans = Math.max(ans, dp[0][j]);
		}
		return ans;
	}
	
	public int coinchange2(int[] A, int B) {
        int dp[] = new int[B + 1];
        dp[0] = 1;
        for(int i = 1; i <= A.length; i++){
            int temp[] = new int[B + 1];
            temp[0] = 1;
            for(int j = 1; j <= B; j++){
                if(A[i - 1] <= j){
                    temp[j] = dp[j] + temp[j - A[i - 1]];
                    temp[j] %= 1000007;
                }
                else{
                    temp[j] = dp[j];
                }
            }
            dp = temp;
        }
        return dp[B];
    }
	
	PriorityQueue<int[]> pq = null;
	
    public int maxScore(int[] nums) {
    	
        pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int X[], int Y[]) {
                return Y[0] - X[0];
            }
        });
        
        int N = nums.length;
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                int val = gcd(nums[i], nums[j]);
                System.out.println(val +" " + i + " " + j);
                pq.offer(new int[]{val, i, j});
            }
        }
        boolean temp[] = new boolean[N];
        int multiplier = N/2;
        int ans = 0;
        while(multiplier>0 && !pq.isEmpty()) {
            int top[] = pq.remove();
            int index1 = top[1];
            int index2 = top[2];
            if(!temp[index1] && !temp[index2]) {
                ans = ans + top[0] * multiplier;
                multiplier--;
                temp[index1]=true;
                temp[index2]=true;
            }
        }
        
        return ans;
    }
    
    
    int gcd(int A, int B) {
        if(A==0) {
            return B;
        }
        return gcd(B%A, A);
    }
}
