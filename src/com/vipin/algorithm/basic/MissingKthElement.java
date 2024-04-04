package com.vipin.algorithm.basic;

public class MissingKthElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []ar= {2,3,4,7,11};
		
		MissingKthElement m = new MissingKthElement();
		System.out.println(m.findKthPositive(ar, 5));
		
		System.out.println(m.findKthPositiveBinarySearch(ar, 5));

	}
	
	public int findKthPositive(int[] arr, int k) {
        int temp = 1;
        int N = arr.length;
       /* for(int i=0; i<N; i++) {
            if(k>0) {
                if(arr[i]==temp) {
                    temp++;
                } else {
                    k--;
                    temp++;
                }
            } else {
                break;
            } 
        }*/
        
        for(int i=0; i<N; ) {
            if(k>0) {
                if(arr[i]!=temp) {
                    k--;
                } else {
                    i++;
                }
                temp++;
            } else {
                break;
            }
        }
                    
        while(k>0) {
            k--;
            temp++;
        }
        
        return temp-1;
    }
	
	
	public int findKthPositiveBinarySearch(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]-(mid+1)>=k)
                high=mid-1;
            else
                low=mid+1;
        }
        return low+k;
    }

}
