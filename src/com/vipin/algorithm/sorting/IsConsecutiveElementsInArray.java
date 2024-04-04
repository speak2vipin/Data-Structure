package com.vipin.algorithm.sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class IsConsecutiveElementsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IsConsecutiveElementsInArray i = new IsConsecutiveElementsInArray();
		int A[] = { 3, 2, 1, 4, 5 };
		System.out.println(i.solve(A));
		int start[] = {1,1};
		int target[] = {8,8};
		int specialRoads[][] = {{3,3,4,2,4},{4,2,7,1,1},{3,3,7,7,3}};
		//System.out.println(i.minimumCost(start, target, specialRoads));
		
		int arr[] = {1,3,4,2}; 
		int mat[][] = {{1,4},{2,3}};
		System.out.println(i.firstCompleteIndex(arr, mat));
		                                   

	}

	public int solve(int[] A) {
		int n = A.length;

		int min = A[0];
		long sum = A[0];

		for (int i = 1; i < n; i++) {
			if (A[i] < min) {
				min = A[i];
			}
			sum += A[i];
		}
		int max = min + n - 1;

		long AP = (((long) n) / 2) * (min + max);

		if (sum == AP) {
			return 1;
		}
		return 0;
	}

	
	public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int N = mat.length;
        int M = mat[0].length;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map.put(mat[i][j], new int[] {i, j});
            }
        }
        boolean temp[][] = new boolean[N][M];
        int count = 0;
        for(int i : arr) {
            int index[] = map.get(i);
            temp[index[0]][index[1]] = true;
            if(check(temp)) {
                return count;
            }
            count++;
        }
        return -1;
        
    }
    boolean check(boolean temp[][]) {
    	
        int N = temp.length;
        int M = temp[0].length;
        for(int i=0; i<N; i++) {
            if(temp[i][0]) {
                int j =1;
                for( ; j<M; j++) {
                    if(!temp[i][j]) {
                        break;
                    }
                }
                if(j==M) {
                    return true;
                }
            }
        }
        for(int i=0; i<M; i++) {
            if(temp[0][i]) {
                int j =1;
                for( ; j<N; j++) {
                    if(!temp[j][i]) {
                        break;
                    }
                }
                if(j==N) {
                    return true;
                }
            }
        }
        return false;
    }
}