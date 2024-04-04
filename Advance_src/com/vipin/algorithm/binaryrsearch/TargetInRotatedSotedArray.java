package com.vipin.algorithm.binaryrsearch;

public class TargetInRotatedSotedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(search(A, 4));
		
		int X[][] = {{1,1,3,3,3}};
		System.out.println(findMedian(X));
	}

	public static int search(final int[] A, int B) {
		int N = A.length;
		int left = 0;
		int right = N - 1;
		int index = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A[mid] >= A[0]) {
				index = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (index == N - 1 || B > A[N - 1]) {
			left = 0;
			right = index;
		} else {
			left = index + 1;
			right = N - 1;
		}

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == B) {
				return mid;
			}
			if (A[mid] < B) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	public static int findMedian(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0; i<N; i++) {
            left = Math.min(left, A[i][0]);
            right = Math.max(right, A[i][M-1]);
        }
        while(left<=right) {
            int mid = left + (right-left)/2;
            for(int i=0; i<N; i++) {
                count += countElementsLessThanMidElement(A[i], mid);
            }
            if(count==(N*M+1)/2) {
                return mid;
            }
            if(count<(N*M)/2) {
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
            
        }
        return left;
    }

    static int countElementsLessThanMidElement(int X[], int mid) {
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

}
