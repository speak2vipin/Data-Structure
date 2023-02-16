package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConvertAllOrangeToRottenBFS {

	public static void main(String[] args) {
		ArrayList<Integer>a1 = new ArrayList<Integer>();
		a1.add(0);a1.add(2);a1.add(1);
		ArrayList<Integer>a2 = new ArrayList<Integer>();
		a2.add(2);a2.add(2);a2.add(1);
		ArrayList<Integer>a3 = new ArrayList<Integer>();
		a3.add(0);a3.add(1);a3.add(0);
		ArrayList<Integer>a4 = new ArrayList<Integer>();
		a4.add(2);a4.add(1);a4.add(1);
		ArrayList<Integer>a5 = new ArrayList<Integer>();
		a5.add(0);a5.add(1);a5.add(1);
		ArrayList<Integer>a6 = new ArrayList<Integer>();
		a6.add(1);a6.add(2);a6.add(1);
		ArrayList<ArrayList<Integer>>A = new ArrayList<ArrayList<Integer>>();	 
		A.add(a1);A.add(a2);A.add(a3);A.add(a4);A.add(a5);A.add(a6);
		
		
		ConvertAllOrangeToRottenBFS c = new ConvertAllOrangeToRottenBFS();
		System.out.println(c.solve(A));
		
		
	}
		// TODO Auto-generated method stubArrayList<E>
	public int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        int count = -1;
        Queue<Point> qe = new LinkedList<Point>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(A.get(i).get(j)==2) {
                    qe.offer(new Point(i, j));
                }
            }
        }
        
        while(!qe.isEmpty()) {
            int size = qe.size();
            for(int k=0; k<size; k++) {
                Point temp = qe.poll();
                int dx = temp.x;
                int dy = temp.y;
                if(dx+1>-1 && dx+1<N && A.get(dx+1).get(dy)==1) {
                	A.get(dx+1).set(dy, 2);
                    qe.offer(new Point(dx+1, dy));
                }
                if(dx-1>-1 && dx-1<N && A.get(dx-1).get(dy)==1) {
                	A.get(dx-1).set(dy, 2);
                	qe.offer(new Point(dx-1, dy));
                }
                if(dy+1>-1 && dy+1<M && A.get(dx).get(dy+1)==1) {
                	A.get(dx).set(dy+1, 2);
                	qe.offer(new Point(dx, dy+1));
                }
                if(dy-1>-1 && dy-1<M && A.get(dx).get(dy-1)==1) {
                	A.get(dx).set(dy-1, 2);
                	qe.offer(new Point(dx, dy-1));
                }
            }
            count++;
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(A.get(i).get(j) == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}




class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

