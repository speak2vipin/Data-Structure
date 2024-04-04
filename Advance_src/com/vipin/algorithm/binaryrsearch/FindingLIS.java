package com.vipin.algorithm.binaryrsearch;

import java.util.Arrays;
import java.util.List;

public class FindingLIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {3,1,5,6,4,2};
		
		FindingLIS fl = new FindingLIS();
		System.out.println(fl.longestObstacleCourseAtEachPosition(A));
		System.out.println(fl.longestObstacleCourseAtEachPositionByArraysMethod(A));

	}

	List<Integer> answer;

	// Find the rightmost insertion position. We use a fixed-length array and a
	// changeable right boundary
	// to represent an arraylist of dynamic size.
	private int bisectRight(int[] A, int target, int right) {
		if (right == 0)
			return 0;
		int left = 0;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (A[mid] <= target)
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}

	public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
		int n = obstacles.length, lisLength = 0;

		// lis[i] records the lowest increasing sequence of length i + 1.
		int[] answer = new int[n], lis = new int[n];

		for (int i = 0; i < n; ++i) {
			int height = obstacles[i];

			// Find the rightmost insertion position idx.
			int idx = bisectRight(lis, height, lisLength);
			if (idx == lisLength)
				lisLength++;

			lis[idx] = height;
			answer[i] = idx + 1;
		}
		return answer;
	}
	
	public int[] longestObstacleCourseAtEachPositionByArraysMethod(int[] obstacles) {
        int N = obstacles.length;
        int lis[] = new int[N];
        int len = 0;
        int answers[] = new int[N];
        for(int i=0; i<N; i++) {
            int index  = Arrays.binarySearch(lis, 0, len, obstacles[i]);
            if(index<0) {
            	index = -index - 1;
            }
            
            lis[index] = obstacles[i];
            answers[i] = index+1;
            if(index == len) {
            	len++;
            }
            
        }
        return answers;
    }
}
