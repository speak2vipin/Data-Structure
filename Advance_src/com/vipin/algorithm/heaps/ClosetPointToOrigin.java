package com.vipin.algorithm.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosetPointToOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = { { 48, 18 }, { 46, 34 }, { 47, 30 }, { 19, 9 }, { 1, 39 }, { 95, 77 }, { 95, 106 }, { 78, 75 },
				{ 92, 108 }, { 89, 83 }, { 80, 76 } };
		ClosetPointToOrigin c = new ClosetPointToOrigin();
		for(int []x : c.solve(A, 5)) {
			System.out.println(x);
		}
		
		String s = "9";
		c.subsequence(s, "");
		System.out.println(c.count);
		

	}

	public int[][] solve(int[][] A, int B) {
		int N = A.length;
		int[][] finalAns = new int[B][];
		PriorityQueue<EuclideanDistance> pq = new PriorityQueue<EuclideanDistance>(
				new Comparator<EuclideanDistance>() {

			@Override
			public int compare(EuclideanDistance o1, EuclideanDistance o2) {
				// TODO Auto-generated method stub
				return o1.dist - o2.dist;
			}

		});

		for (int i = 0; i < N; i++) {
			pq.offer(new EuclideanDistance(A[i][0], A[i][1]));
		}
		int index = 0;
		while (!pq.isEmpty() && B>0) {
			EuclideanDistance tempEuclideanDistance = pq.poll();
			finalAns[index++] = new int[] { tempEuclideanDistance.x, tempEuclideanDistance.y };
			B--;
		}

		return finalAns;
	}
	
	long count = 0;
    long mod = 1000000007;
    public int numDiv9(String A) {
        subsequence(A, "");
        return (int)mod;
        
    }
    
    void subsequence(String s, String ans){
        if(s.length()==0) {
            if(isDiv(ans)) {
                count = (count+1)%mod;
            }
            //subseq.add(ans);
            return;
        }
        subsequence( s.substring(1),  ans+s.charAt(0));
        subsequence( s.substring(1),  ans);
    }
    
    boolean isDiv(String s) {
    	if(s.length()==0) {
    		return false;
    	}
        int sum = 0;
        for(int i=0; i<s.length(); i++) {
            sum += s.charAt(i)-'0';
        }
        return (sum%9)==0 ? true : false;
    }

}

class EuclideanDistance {
	int x;
	int y;
	int dist;

	public EuclideanDistance(int x, int y) {
		this.x = x;
		this.y = y;
		this.dist = x * x + y * y;
	}
}
