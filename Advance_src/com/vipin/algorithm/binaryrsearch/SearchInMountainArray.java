package com.vipin.algorithm.binaryrsearch;

public class SearchInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mountainArr[] = {3,5,3,2,0};
		SearchInMountainArray s = new SearchInMountainArray();
		System.out.println(s.findInMountainArray(0, mountainArr));

	}
	
	 public int findInMountainArray(int target, int[] mountainArr) {
	        int n = mountainArr.length;
	        int peak = getPeak(mountainArr, 0, n-1);
	        int left = binarySearchIncreasing(mountainArr, 0, peak, target);
	        if(left==-1) {
	            int right = binarySearchDeacresing(mountainArr, peak+1, n-1, target);
	            return right;
	        }
	        return left;
	    }
	    int getPeak(int []mountainArr, int st, int en) {
	        while(st<=en) {
	            int mid = en - (en-st)/2;
	            int val = mountainArr[mid];
	            int prev = mountainArr[mid-1];
	            int next = mountainArr[mid+1];
	            if(val>prev && val>next) {
	                return mid;
	            }
	            if(val>prev && val<next) {
	                st = mid + 1;
	            } else {
	                en = mid - 1;
	            }
	        }
	        return -1;
	    }
	    
	    int binarySearchIncreasing(int arr[], int st, int en, int target) {
	        while(st<=en) {
	            int mid = en - (en-st)/2;
	            int val = arr[mid];
	            if(val==target) {
	                return mid;
	            }
	            if(val>target) {
	                en = mid - 1;
	            } else {
	                st = mid + 1;
	            }
	        }
	        return -1;
	    }
	    int binarySearchDeacresing(int arr[], int st, int en, int target) {
	        while(st<=en) {
	            int mid = en - (en-st)/2;
	            int val = arr[mid];
	            if(val==target) {
	                return mid;
	            }
	            if(val>target) {
	                st = mid + 1;
	            } else {
	                en = mid - 1;
	            }
	        }
	        return -1;
	    }

}
