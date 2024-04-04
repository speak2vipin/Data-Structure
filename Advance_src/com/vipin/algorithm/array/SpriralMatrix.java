package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class SpriralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		for (int x : spiralOrder(matrix)) {

			System.out.println(x);
		}
		int A[][] = {{ 1, 1,3,3, 3}};
		SpriralMatrix  s = new SpriralMatrix();
		//s.findMedian(A);
		for (int x[] : s.generateMatrix(3)) {
			for(int y :  x) {
				System.out.print(y);
			}
			System.out.println();
		}
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		int N = matrix.length;
        int M = matrix[0].length;
        int total = N*M;
        int x = 0;
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while(true) {
            while(count<total && j+x<M) {
                list.add(matrix[i][j]);
                j++;
                count++;
            }
            
            i++;
            j--;
            while(count<total && i+x<N) {
                list.add(matrix[i][j]);
                i++;
                count++;
            }
            j--;
            i--;
            while(count<total && j-x>-1) {
                list.add(matrix[i][j]);
                j--;
                count++;
            }
            i--;
            j++;
            while(count<total && i-x>0) {
                list.add(matrix[i][j]);
                i--;
                count++;
            }
            j++;
            i++;
            x++;
            if(count==total) {
            	break;
            }
        }
		return list;
	}
	
	public int findMedian(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
       // int count = 0;
        for(int i=0; i<N; i++) {
            left = Math.min(left, A[i][0]);
            right = Math.max(right, A[i][M-1]);
        }
        while(left<=right) {
            int mid = left + (right-left)/2;
            int count = 0;
            for(int i=0; i<N; i++) {
                count += countElementsLessThanMidElement(A[i], mid);
            }
            /*if(count==(N*M+1)/2) {
                return mid;
            }*/
            if(count<=(N*M)/2) {
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
            
        }
        return left;
    }

    int countElementsLessThanMidElement(int X[], int mid) {
        int st = 0;
        int en = X.length-1;
        while(st<=en) {
            int m = st + (en-st)/2;
            if(X[m]<=mid) {
                st = m+1;
            } else {
                en = m-1;
            }
        }
        return st;
    }
	
	public class Solution {
	    public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> res = new ArrayList<Integer>();
	        if(matrix.length == 0 || matrix[0].length == 0) return res;
	        
	        int top = 0;
	        int bottom = matrix.length-1;
	        int left = 0;
	        int right = matrix[0].length-1;
	        
	        while(true){
	            for(int i = left; i <= right; i++) res.add(matrix[top][i]);
	            top++;
	            if(left > right || top > bottom) break;
	            
	            for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
	            right--;
	            if(left > right || top > bottom) break;
	            
	            for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
	            bottom--;
	            if(left > right || top > bottom) break;
	            
	            for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
	            left++;
	            if(left > right || top > bottom) break;
	        }
	        
	        return res;
	    }
	    
	}
	
	public int[][] generateMatrix(int n) {
        int ans[][] = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int count = 1;
        while(true) {
            for(int j=left; j<=right; j++) {
                ans[top][j] = count++;
            }
            top++;
            if(top>n-1 || top>bottom) {
                break;
            }
            
            for(int i=top; i<=bottom; i++) {
                ans[i][right] = count++;
            }
            right--;
            if(right<0 || left>right) {
                break;
            }
            
            for(int j=right; j>=left; j--) {
                ans[bottom][j] = count++;
            }
            bottom--;
            if(bottom<0 || bottom<top) {
                break;
            }
            
            for(int i=bottom; i>=top; i--) {
                ans[i][left] = count++;
            }
            left++;
            if(left>n-1 || left>right) {
                break;
            }
        }
        return ans;
    }
}
