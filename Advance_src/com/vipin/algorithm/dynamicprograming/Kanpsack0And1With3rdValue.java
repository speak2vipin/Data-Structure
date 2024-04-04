package com.vipin.algorithm.dynamicprograming;

public class Kanpsack0And1With3rdValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 6, 10, 12 };
		int B[] = { 10, 20, 30};
		int C = 50;
		
		Kanpsack0And1With3rdValue k = new Kanpsack0And1With3rdValue();
		System.out.println(k.solve1(A, B, C));
	}

	public int solve(int[] A, int[] B, int C) {
		int N = A.length;
		int dp[][] = new int[N+1][C+1];
		return helper(0, A, B, C, dp);
	}

	int helper(int index, int A[], int B[], int C, int dp[][]) {
		if (index >= A.length) {
			return 0;
		}
		if (dp[index][C] != 0) {
			return dp[index][C];
		}
		if(B[index]>C) {
			dp[index][C] = helper(index + 1, A, B, C, dp);
		} else {
			dp[index][C] = Math.max(A[index] + helper(index + 1, A, B, C - B[index], dp), helper(index + 1, A, B, C, dp));
		}
		System.out.println(index + " " + C + " " +dp[index][C] + " " + C);
		return dp[index][C];
	}
	
	public int solve1(int[] A, int[] B, int C) {
		int N = A.length;
		//int dp[][] = new int[N+1][C+1];
        int values = 0;
		for(int a : A) {
            values += a;
        }
        int dp[][] = new int[N][values+1];
        helper1(0, A, B, values, dp);
        int res = 0;
        for(int j=values; j>-1; j--) {
            if(dp[N-1][j]!=0 && dp[N-1][j]<=C) {
                return j;
            }
        }
        return 0;
	}

    int helper1(int index, int A[], int B[], int sum, int dp[][]) {
		if (index >= A.length) {
			return 0;
		}
		if (dp[index][sum] != 0) {
			return dp[index][sum];
		}
		if(A[index]>sum) {
			dp[index][sum] = helper1(index + 1, A, B, sum, dp);
		} else {	
			dp[index][sum] = 
            Math.max(B[index] + 
            helper1(index + 1, A, B, sum - A[index], dp), helper1(index + 1, A, B, sum, dp));
		}
		//System.out.println(index + " " + C + " " +dp[index][C] + " " + C);
		return dp[index][sum];
	}
    
    for (int i = 0; i < n; i++) sum += A.get(i);
    int dp[][] = new int[n + 1][sum + 1];

    for (int i = 0; i <= n; i++) dp[i][0] = 0;
    for (int i = 1; i <= sum; i++) dp[0][i] = Integer.MAX_VALUE;


    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= sum; j++) {
            int choice1 = Integer.MAX_VALUE;
            if (j - A.get(i - 1) >= 0 && dp[i - 1][j - A.get(i - 1)] != Integer.MAX_VALUE) {
                choice1 = B.get(i - 1) + dp[i - 1][j - A.get(i - 1)];
            }
            dp[i][j] = Math.min(choice1, dp[i - 1][j]);
        }
    }
   
    for (int i = sum; i >= 0; i--)
        if (dp[n][i] <= C) return i;

    return 0;
}
