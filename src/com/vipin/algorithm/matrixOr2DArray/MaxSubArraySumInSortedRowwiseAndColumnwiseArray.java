package com.vipin.algorithm.matrixOr2DArray;

public class MaxSubArraySumInSortedRowwiseAndColumnwiseArray {
	public static void main(String[] args) {
		int A[][] = {  {-83, -73, -70, -61},
			  {-56, -48, -13, 4},
			  {38, 48, 71, 71} };
		System.out.println(solve(A));	

		
	}

	 public static long solve(int[][] A) {
			// S[i][j] = A[i][j] + S[i][j+1] + S[i+1][j] - S[i+1][j+1];
			int M = A.length - 1;
			int N = A[0].length - 1;
	        // Becuase of long need to take temp. So space complexity is O(M+N) or else it would be 1 i.e. constant
			long[][] temp = new long[M+1][N+1];
			long max = Long.MIN_VALUE;
			for (int i = M; i > -1; i--) {
				for (int j = N; j > -1; j--) {
					temp[i][j] = A[i][j];
					if (j + 1 <= N) {
						temp[i][j] += temp[i][j + 1];
					}
					if (i + 1 <= M) {
						temp[i][j] += temp[i + 1][j];
					}
					if (j + 1 <= N && i + 1 <= M) {
						temp[i][j] -= temp[i + 1][j + 1];
					}
					max = Math.max(max, temp[i][j]);
				}
			}
			return max;
		}
	 
	 public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
	        // P[i][j] = A[i][j] + P[i][j-1] + P[i-1][j] - P[i-1][j-1];
	        int Q = B.length;
	        int ans[] = new int[Q];
	        int N = A.length;
	        int M = A[0].length;
	        long[][] P = new long[N][M];
	        for(int i=0; i<N; i++) {
	            for(int j=0; j<M; j++) {
	                P[i][j] = A[i][j];
	                if(j-1>-1) {
	                    P[i][j]+=P[i][j-1];
	                }
	                if(i-1>-1) {
	                    P[i][j]+=P[i-1][j];
	                } 
	                if(i-1>-1 && j-1>-1) {
	                    P[i][j]-=P[i-1][j-1];
	                }
	            }
	        }
	        for(int k=0; k<Q; k++) {
	            int x1 = B[k]-1;
	            int y1 = C[k]-1;
	            int x2 = D[k]-1;
	            int y2 = E[k]-1;
	            long temp = 0l;
	            //ans[k] = A[x2][y2] - A[x2][y1-1] - A[x1-1][y2] + A[x1-1][y1-1];
	            temp = P[x2][y2];
	            if(y1-1>-1) {
	                temp -= P[x2][y1-1];
	            }
	            if(x1-1>-1) {
	                temp -= P[x1-1][y2];
	            }
	            if(x1-1>-1 && y1-1>-1) {
	                temp += P[x1-1][y1-1];
	            }
	          //Taking Mod to put answer in the required range of accepted answer.
	            temp = temp % 1000000007;
	            if(temp < 0) {
	            	temp = (temp + 1000000007) % 1000000007;
	            }
	            ans[k] = (int)temp%1000000007;
	        }
	        return ans;
	    }
	 
	 
}


