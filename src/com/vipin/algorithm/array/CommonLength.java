package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1,2,3,8,9};
		int B[] = {3,8,9, 10,15};
		System.out.println(findLength(A, B));
		

	}
	
	public static int findLength(int[] A, int[] B) {
        int ans = 0;
        Map<Integer, ArrayList<Integer>> Bstarts = new HashMap();
        for (int j = 0; j < B.length; j++) {
            Bstarts.computeIfAbsent(B[j], x -> new ArrayList()).add(j);
        }

        for (int i = 0; i < A.length; i++) if (Bstarts.containsKey(A[i])) {
            for (int j: Bstarts.get(A[i])) {
                int k = 0;
                while (i+k < A.length && j+k < B.length && A[i+k] == B[j+k]) {
                    k++;
                }
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }
	
	

}
