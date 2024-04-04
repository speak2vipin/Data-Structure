package com.vipin.algorithm.sorting;

public class SpecialNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {14046, 57239, 78362, 99387, 27609, 55100, 65536, 62099, 40820, 33056,
				88380, 78549, 57512, 33137, 81212, 32365, 42276, 65368, 52459, 74924, 25355, 
				76044, 78056, 45190, 94365, 58869, 20611 };
		SpecialNumber s = new SpecialNumber();
		
		System.out.println(s.solve(A));
	}
	
	 int ans = 0;
	    public int solve(int[] A) {
	        mergeSort(A, 0, A.length-1);
	        return ans;
	    }
	    void mergeSort(int A[], int st, int en) {
	        if(st>=en) {
	            return;
	        }
	        int mid = (st+en)/2;
	        mergeSort(A, st, mid);
	        mergeSort(A, mid+1, en);
	        merge(A, st, mid, en);
	    }

	    void merge(int A[], int st, int mid, int en) {
	        int N = mid - st + 1;
	        int M = en - (mid+1)+1;

	        int B[] = new int[N];
	        int C[] = new int[M];

	        for(int i=st; i<mid+1; i++) {
	            B[i-st] = A[i];
	        }
	        for(int i=mid+1; i<en+1; i++) {
	            C[i-mid-1] = A[i];
	        }
	        int i=0, j=0;
	        while(i<N && j<M) {
	            // Before merging the array count the reverse pairs
	            long l1 = B[i];
	            long l2 = C[j];
	            if(l1>2*l2) {
	                ans += N-1-i+1;
	                j++;
	            } else
	                i++;
	        }
	        i=0; j=0;
	        int index=st;
	        while(i<N && j<M) {
	            if(B[i]<C[j]) {
	                A[index++] = B[i++];
	            } else {
	                A[index++] = C[j++];
	            }
	        }
	        while(j<M) {
	            A[index++] = C[j++];
	        }
	        while(i<N) {
	            A[index++] = B[i++];
	        }
	    }

}
