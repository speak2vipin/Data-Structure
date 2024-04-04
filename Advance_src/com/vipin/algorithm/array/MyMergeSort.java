package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MyMergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long arr[] = {2, 4, 1, 3, 5};
		System.out.println(inversionCount(arr, 5));
		int ar1[] = {45,10,15,25,50};
		MyMergeSort m = new MyMergeSort();
		m.solve(ar1);
		System.out.println(m.ans);
		
		int x[] = {2,4,5,1,3};
		System.out.println(m.minSwaps(x));
		
	}
	static long count = 0;
	static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        mergeSort(arr, 0, (int)N-1);
        return count;
    }
    static void mergeSort(long arr[], int left, int right) {
        if(left<right) {
            int mid = (left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            mergeTwoArray(arr, left, mid, right);
        }
    }
    
    static void mergeTwoArray(long arr[], int left, int mid, int right) {
        int l1 = mid-left+1;
        int l2 = right-mid;
        long arr1[] = new long[l1];
        long arr2[] = new long[l2];
        for(int i=left; i<mid+1;i++) {
            arr1[i-left] = arr[i];
        }
        for(int i=mid+1; i<right+1; i++) {
            arr2[i-mid-1] = arr[i];
        }
        int i=0, j=0;
        int k = left;
        while(i<l1 && j<l2) {
            if(arr1[i]<=arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
               count+=l1-i;
                j++;
            } 
            k++;
        }
        while(i<l1) {
        	//count++;
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while(j<l2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }
    
    int ans = 0;
    public int solve(int[] A) {
        // Merge Sort
        sort(A, 0, A.length-1);
        return ans;
    }

    void sort(int A[], int s, int e) {
        if(s<e) {
            int m = (s+e)/2;
            sort(A, s, m);
            sort(A, m+1, e);
            mergeArray(A, s, m, e);
        }
    }

    void mergeArray(int A[], int s, int m, int e) {
        int n1 = m-s+1;
        int n2 = e-(m+1)+1;
        int left[] = new int[n1];
        int right[] = new int [n2];
        for(int i=s; i<m+1; i++) {
            left[i-s] = A[i];
        }
        for(int i=m+1; i<e+1; i++) {
            right[i-m-1] = A[i];
        }
        int i=0, j=0, swaps = 0;
        int k = s;
        while(i<n1 && j<n2) {
            if(left[i]<=right[j]) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
                ans = (ans + (n1-i))%1000000007;
            }
        }
        while(i<n1) {
            A[k++] = left[i++];
        }
        while(j<n2) {
            A[k++] = right[j++];
        }
    }
    
    public int minSwaps(int nums[])
    {
        // Code here
        ArrayList<int[]> pairs = new ArrayList<>();
        int N = nums.length;
        for(int i=0; i<N; i++) {
            pairs.add(new int[] {nums[i], i});
        }
        Collections.sort(pairs, (p1, p2) -> p1[0]-p2[0]);
        boolean visit [] = new boolean[N];
        int swaps = 0;
        for(int i=0; i<N; i++) {
            int []pair = pairs.get(i);
            if(pair[1]==(i+1) || visit[i]) {
                continue;
            }
            int j=pair[1];
            int cycle = 0;
            while(!visit[j]) {
            	cycle++;
                visit[j] = true;
                j = pairs.get(j)[1];
            }
            if(cycle>0) {
            	swaps+=cycle-1;
            }
        }
        return swaps;
    }

}
