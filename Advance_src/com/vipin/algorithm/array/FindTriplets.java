package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FindTriplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {-5,2,1,3};
		//System.out.println(threeSum(A));
		
		int B[] = {0, 1};
		System.out.println(sortArrayByParity(B));
		
		String s = "leet2code3";
		int k = 10;
		System.out.println(decodeAtIndex(s, k));
		
		
	}
	
	public static int[][] threeSum(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int a : A) {
            set.add(a);
        }
        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);
        ArrayList<int[]>res = new ArrayList<>();
        int N = list.size();
        for(int i=0; i<N; i++) {
            int j = i+1;
            int k = N-1;
            while(j<k) {
                int sum = list.get(i) + list.get(j) + list.get(k);
                if(sum==0) {
                    res.add(new int[]{i,j,k});
                    j++;
                    k++;
                } else if(sum>0) {
                    k--;
                } else {
                    j++;
                }
                
            }
        }
        int[][]response = new int[res.size()][3];
        int i=0;
        for(int[] r : res) {
            response[i++] = new int[] {list.get(r[0]), list.get(r[1]), list.get(r[2])};
        }
        return response;
    }
	
	public static int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        while(j<n && i<n) {
            if((nums[j]%2)!=0) {
                i = Math.max(i, j);
                while(i<n && (nums[i]%2)!=0) {
                    i++;
                }
                if(i<n) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            } 
            j++;
        }
        return nums;
    }
	
	public static String decodeAtIndex(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = s.length();
        while(i<n) {
            char temp = s.charAt(i);
            if(Character.isDigit(temp)) {
                int count = temp - '0';
                while(count-1>0) {
                    sb.append(sb);
                    count--;
                }
            } else {
            	sb.append(temp);
            }
            i++;
        }
        return new String(sb.substring(k,k+1));
        
    }

}
