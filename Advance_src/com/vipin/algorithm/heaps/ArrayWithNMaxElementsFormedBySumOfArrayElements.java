package com.vipin.algorithm.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class ArrayWithNMaxElementsFormedBySumOfArrayElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer A[] = {1, 4, 2, 3};
		Integer B[] = {2, 5, 1, 6};
		ArrayList<Integer>i1 = new ArrayList<Integer>();
		i1.add(1);i1.add(4);i1.add(2);i1.add(3);
		ArrayList<Integer>i2 = new ArrayList<Integer>();
		i2.add(2);i2.add(5);i2.add(1);i2.add(6);
		ArrayWithNMaxElementsFormedBySumOfArrayElements a =
				new ArrayWithNMaxElementsFormedBySumOfArrayElements();
		a.solve(i1, i2);

	}

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		Collections.sort(A);
		Collections.sort(B);
		HashSet<String> set = new HashSet<>();
		PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] x, int[] y) {
				// TODO Auto-generated method stub
				return ((A.get(y[0]) + B.get(y[1])) - (A.get(x[0]) + B.get(x[1])));
			}
		});

		int N = A.size();
		maxHeap.offer(new int[] { N - 1, N - 1 });
		ArrayList<Integer> ans = new ArrayList<>();
		int diff = -1;
		String key = null;
		for (int i = 0; i < N; i++) {
			int[] top = maxHeap.poll();
			int AIndex = top[0];
			int BIndex = top[1];
			ans.add(A.get(AIndex) + B.get(BIndex));
			diff = BIndex-1;
			key = AIndex + "@" + diff;
			if (set.add(key) && BIndex - 1 > -1) {
				maxHeap.offer(new int[] { AIndex, BIndex - 1 });
			}
			diff = AIndex-1;
			key = diff + "@" + BIndex;
			if (set.add(key) &&  AIndex - 1 > -1) {
				maxHeap.offer(new int[] { AIndex - 1, BIndex });
			}
		}
		return ans;
	}
	
	public int solve(ArrayList<Integer> A) {
        ArrayList<Double> LtToRt = getmedian(A);
        for(int i = 0; i < LtToRt.size()- 1 ; i++){
            if(LtToRt.get(i).equals(A.get(i + 1).doubleValue())){
                return 1;
            }
        }
        Collections.reverse(A);
        ArrayList<Double> RtToLt = getmedian(A);
         for(int i = 0; i < RtToLt.size()-1 ; i++){
            if(RtToLt.get(i).equals(A.get(i + 1).doubleValue())){
                return 1;
            }
        }
        return 0;
    }
     public ArrayList<Double> getmedian(ArrayList<Integer> A) {
         PriorityQueue<Integer> minrt = new PriorityQueue<>();
         PriorityQueue<Integer> maxlt = new PriorityQueue<>( Collections.reverseOrder());
         ArrayList<Double> ans = new ArrayList<>();

        for(int i = 0; i < A.size(); i++){
           if(i%2 == 0){
               minrt.add(A.get(i));
               maxlt.add(minrt.remove());
               ans.add((double)maxlt.peek());
           }
           else if(i%2 != 0){
               maxlt.add(A.get(i));
               minrt.add(maxlt.remove());
               ans.add((maxlt.peek() + minrt.peek())/2.0);
           }
         }
         return ans;
    }
	

}
