package com.vipin.algorithms.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SortMatrixDiagonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]a = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
		int [][]b = {{3,9},{2,4},{1,2},{9,8},{7,3}};
		// // [[1, 2, 1, 1], [2, 3, 1, 2], [3, 1, 1, 2]]
		// // [[1,1,1,1],[1,2,2,2],[1,2,3,3]]  [[1, 1, 1, 1], [1, 2, 2, 2], [1, 2, 3, 3]]
		diagonalSort(b);
	}
	
	 public static int[][] diagonalSort(int[][] a) {
	        int M = a.length;
	        int N = a[0].length;
	        for(int j=N-1;j>-1;j--) {
	            int i=0, k=j;
	           // List<Integer> list = new ArrayList<Integer>();
	            PriorityQueue<Integer> pe = new PriorityQueue<Integer>();
	            while(i<M && k<N) {
	                //list.add(a[i][k]);
	                pe.add(a[i][k]);
	                i++;
	                k++;
	            }
	           // Collections.sort(list);
	            i=0;
	            k=j;
	            //int index = 0;
	            //while(i<M && k<N && index<list.size()) {
	            while(i<M && k<N && !pe.isEmpty()) {
	                //a[i][k] = list.get(index);
	            	a[i][k] = pe.poll();
	                i++;
	                k++;
	               // index++;
	            }    
	        }
	        
	        for(int i=1;i<M;i++) {
	            int j=0, k=i;
	            //List<Integer> list = new ArrayList<Integer>();
	            PriorityQueue<Integer> pe = new PriorityQueue<Integer>();
	            while(k<M && j<N) {
	                //list.add(a[k][j]);
	            	pe.add(a[k][j]);
	                k++;
	                j++;
	            }
	            //Collections.sort(list);
	            k=i;
	            j=0;
	            //int index = 0;
	            while(k<M && j<N && !pe.isEmpty()) {
	                //a[k][j] = list.get(index);
	            	a[k][j] = pe.poll();
	                k++;
	                j++;
	                //index++;
	            }    
	        }
	        return a;
	    }
	 // [[1, 2, 1, 1], [2, 3, 1, 2], [3, 1, 1, 2]]
	 // [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
	 // [[3, 9], [2, 4], [1, 2], [9, 8], [7, 3]]
	 // [[3,9],[2,4],[1,2],[3,8],[7,9]]
	 //[[3, 9], [2, 4], [1, 2], [3, 8], [7, 9]]
	 // [[3, 9], [2, 4], [1, 2], [9, 8], [7, 3]]
	 //[[2, 9], [2, 3], [1, 3], [3, 3], [7, 9]]
	 // [[3, 9], [2, 4], [1, 2], [3, 8], [7, 9]]

}
