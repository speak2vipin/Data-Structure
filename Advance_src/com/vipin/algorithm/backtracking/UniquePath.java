package com.vipin.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePath {
	int ans = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]A = {{1, 0, 0, 0},
		        	{2, 0, 0, 0},
		            {0, 0, 2, -1}};
		ArrayList<Integer>a1 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 0, 0, 0}));
		ArrayList<Integer>a2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{0, 0, 0, 0}));
		ArrayList<Integer>a3 = new ArrayList<Integer>(Arrays.asList(new Integer[]{0, 0, 2, -1}));
		
		ArrayList<ArrayList<Integer>> Aa = new ArrayList<ArrayList<Integer>> ();
		Aa.add(a1);Aa.add(a2);
		Aa.add(a3);
		UniquePath u = new UniquePath();
		//System.out.println(u.solve(Aa));;
		System.out.println(u.myPow(2, -2));
		

	}

	int totalZeroes = 0;
	Integer[][] a;
	int N;
	int M;
	int visit = 0;

	/*public int solve(ArrayList<ArrayList<Integer>> A) {
		M = A.get(0).size();
		N = A.size();
		a = new Integer[N][];
		int st[][] = new int[1][2];
		
		int index = 0;
		for(ArrayList<Integer> temp : A) {
			a[index++] = temp.toArray(new Integer[M]);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i][j] == 0) {
					totalZeroes++;
				}
				if (a[i][j] == 1) {
					st[0][0] = i;
					st[0][1] = j;
				}
			}
		}
		return check(st[0][0], st[0][1], 0);
	}*/
	
	public int solve(ArrayList<ArrayList<Integer>> A) {
		M = A.get(0).size();
		N = A.size();
		a = new Integer[N][];
		int total = 0;
		int index = 0;
		for(ArrayList<Integer> temp : A) {
			a[index++] = temp.toArray(new Integer[M]);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i][j] == -1) {
					total++;
				}
			}
		}
		visit = N*M - total;
		return check(0, 0, 1);
	}
	
	int check(int i, int j, int count) {
		
		if (i < 0 || i > N - 1 || j < 0 || j > M - 1) {
			return 0;
		}
		if (a[i][j] == -1 || a[i][j]==-2) {
			return 0;
		}
		System.out.println(i + " " + j + " " + (count));
		if (a[i][j] == 2) {
			System.out.println(2 + " ----> " +count);
			if(count == visit ) {
				return 1;
			}
			return 0;
		}
		
		a[i][j]=-2;

		int ans = check(i - 1, j, count+1)
				+check(i+1, j, count+1)
				+check(i, j - 1, count+1)
				+check(i, j+1, count+1);
		a[i][j]=0;
		return ans;
	}


	/*int check(int x, int y, int zeroCount) {
		// 1, 0, 0, 0},
    	//{0, 0, 0, 0},
        //{0, 0, 2, -1
		
		if (x < 0 || x > N - 1 || y < 0 || y > M - 1) {
			return 0;
		}
		
		if (a[x][y] == -1|| a[x][y]==-2) {
			return 0;
		}
		if (a[x][y] == 2) {
			System.out.println(x +" " + y + " " + zeroCount + " "+a[x][y]);
			if(zeroCount == visit) {
				return 1;
			}
			return 0;
		}
		if (a[x][y] == 0) {
			zeroCount++;
		}a
		System.out.println(x +" " + y + " " + zeroCount + " "+a[x][y]);
		a[x][y] = -2;
		
		int ans = check(x - 1, y, zeroCount) + 
				check(x + 1, y, zeroCount) + 
				check(x, y - 1, zeroCount) + 
				check(x, y + 1, zeroCount);
		a[x][y] = 0;
		return ans;
	}*/
	

}
