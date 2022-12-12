package com.vipin.algorithm.binarysearch;

public class FindRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public int[] searchRange(final int[] A, int B) {
        int N = A.length;
        int l = 0;
        int r = N-1;
        int mid = 0;
        int lhs = -1;
        int rhs = -1;
        while(l<=r) {
            mid = (l+r)/2;
            if(A[mid]==B) {
                if(mid==0 || A[mid-1]!=B) {
                    lhs = mid;
                    break;
                } else {
                    r = mid-1;
                }
            }
            if(A[mid]>B) {
                r = mid-1;
            } else if(A[mid]<B) {
                l = mid+1;
            }
        }
        l = 0;
        r = N-1;
        mid = 0;
        while(l<=r) {
            mid = (l+r)/2;
            if(A[mid]==B) {
                if(mid == N-1 || A[mid]!=A[mid+1]) {
                    rhs = mid;
                    break;
                } else {
                    l = mid+1;
                }
            }
            if(A[mid]>B) {
                r = mid-1;
            } else if(A[mid]<B) {
                l = mid+1;
            }
        }
        int ans[] = new int[2];
        ans[0] = lhs;
        ans[1] = rhs;
        return ans;
    }

}
