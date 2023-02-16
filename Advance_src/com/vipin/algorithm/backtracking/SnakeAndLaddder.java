package com.vipin.algorithm.backtracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLaddder {
	int size = -1;
    int N = -1;
    int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int board[][] = new int[6][];
	
		int board1[] = {-1,-1,-1,-1,-1,-1};
		int board2[] = {-1,-1,-1,-1,-1,-1};
		int board3[] = {-1,-1,-1,-1,-1,-1};
		int board4[] = {-1,35,-1,-1,13,-1};
		int board5[] = {-1,-1,-1,-1,-1,-1};
		int board6[] = {-1,15,-1,-1,-1,-1};
		board[0] = board1;
		board[1] = board2;
		board[2] = board3;
		board[3] = board4;
		board[4] = board5;
		board[5] = board6;
		SnakeAndLaddder s = new SnakeAndLaddder();
		System.out.println(s.snakesAndLadders(board));
	}

	    
	    public int snakesAndLadders(int[][] board) {
	        int N = board.length;
	        Map<Integer, Integer>map = new HashMap<Integer, Integer>();
	         Queue<Integer> qe = new LinkedList<Integer>();
	         map.put(1,0);
	         qe.offer(1);
	         while(!qe.isEmpty()) {
	             int p = qe.poll();
	             if(p==N*N) {
	                 return map.get(p);
	             }
	             for(int i=p+1; i<=Math.min(p+6, N*N); i++) {
	                 int next = i;
	                 int rowIndex = (next-1)/N;
	                 int colIndex = (next-1)%N;
	 	            int actualRowIndex = N-rowIndex-1;
	 	            int actualColIndex = -1;
	 	            if(rowIndex%2==0) {
	 	                actualColIndex = colIndex;
	 	            } else {
	 	                actualColIndex = N-1-colIndex;
	 	            }
	 	            System.out.println(actualRowIndex+" "+actualColIndex);
	                 int ns = board[actualRowIndex][actualColIndex]==-1 ? i : board[actualRowIndex][actualColIndex];
	                 
	                 if(!map.containsKey(ns)) {
	                     map.put(ns, map.get(p)+1);
	                     qe.offer(ns);
	                 }
	             }
	         }
	         return -1;
	     }
}
	  
	     /*   public int snakesAndLaddersLeetcode(int[][] board) {
	        	 int n=board.length;
	             Map<Integer,Integer>hm=new HashMap<>();
	             hm.put(1,0);
	             Queue<Integer>q=new LinkedList<>();
	             q.add(1);
	             while(!q.isEmpty()){
	                 int p=q.poll();
	                 if(p==n*n) return hm.get(p);
	                 for(int i=p+1;i<=Math.min(p+6,n*n);i++){
	                     int next=check(i,n);
	                     int row=next/n,col=next%n;
	                     int ns=board[row][col]==-1?i:board[row][col];
	                     if(!hm.containsKey(ns)){
	                         hm.put(ns,hm.get(p)+1);
	                         q.offer(ns);
	                     }
	                 }
	             }
	             return -1;
	         }
	         public static int check(int i,int n){
	             int q=(i-1)/n,r=(i-1)%n;
	             int row=n-1-q;
	             int col=row%2!=n%2?r:n-1-r;
	             return row*n+col;
	         }
	         */
