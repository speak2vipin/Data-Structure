package com.vipin.algorithm.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxDivisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer> ();
		A.add(1);A.add(2);A.add(3);A.add(5);
		MaxDivisor m = new MaxDivisor();
		System.out.println(m.solve(A, 3));
	}
	
	 public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
	        PriorityQueue<Dummy>pq = new PriorityQueue<Dummy>(new Comparator<Dummy>() {
				@Override
				public int compare(Dummy o1, Dummy o2) {
					// TODO Auto-generated method stub
					return o1.div-o2.div>0?1:-1;
				}
	        });
	        
	        int st = 0;
	        int en = A.size()-1;
	        for(int i=en; i>-1; i--) {
	        	double div = (double)A.get(0)/A.get(i);
	        	pq.offer(new Dummy(0, i, div));
	        }
	        Dummy temp = null;
	        while(B>0 && !pq.isEmpty()) {
	        	temp = pq.poll();
	        	int tempSt = temp.a;
	        	int tempEn = temp.b;
	        	if(tempSt<tempEn) {
	        		double div = (double)A.get(tempSt+1)/A.get(tempEn);
	        		pq.offer(new Dummy(tempSt+1, tempEn, div));
	        	}
	        	B--;
	        }
	        ArrayList<Integer> ans = new ArrayList<Integer>();
	        ans.add(A.get(temp.a)); ans.add(A.get(temp.b));
	        return ans;
	    }

}

class Dummy {
    int a;
    int b;
    double div;
	public Dummy(int a, int b, double div) {
		super();
		this.a = a;
		this.b = b;
		this.div = div;
	}
    
}
