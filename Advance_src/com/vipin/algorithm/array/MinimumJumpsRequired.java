package com.vipin.algorithm.array;

import java.util.Arrays;
import java.util.HashSet;

public class MinimumJumpsRequired {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = { 1, 2, 0, 0, 0 };
		System.out.println(minJumps(num));
		
		int n[] = {9, 10, 1, 2, 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 1};
		System.out.println(minJumps1(n));
		
		//int nums[] = {1,2,3,10,20};
		int nums[] = {8,10,16,18,10,10,16,13,13,16};
		
		MinimumJumpsRequired m = new MinimumJumpsRequired();
		System.out.println(m.minOperations2(nums));
	}

	static int minJumps(int[] arr) {
		// your code here
		int count = 0;
		int n = arr.length;
		if (n == 1) {
			return 0;
		}
		int newOrigin = 0;
		for (int i = 0; i < n;) {
			int step = arr[i];
			int max = Integer.MIN_VALUE;
			count++;
			newOrigin = i;
			if (step == 0) {
				return -1;
			}
			for (int j = 1; j <= step && j < n; j++) {
				if (i + j + arr[i + j] >= n - 1) {
					return count + 1;
				}
				if (max < i + j + arr[i + j]) {
					max = i + j + arr[i + j];
					newOrigin = i + j;
				}
			}

			i = newOrigin;
		}
		return -1;
	}

	static int minJumps1(int[] arr) {

		// your code here
		int count = 0;
		int n = arr.length;
		int current = 0;
		int farthest = 0;
		for (int i = 0; i < n; i++) {
			farthest = Math.max(farthest, i + arr[i]);
			if (current == i) {
				current = farthest;
				count++;
			}
		}
		return count;
	}
	
	public int minOperations(int[] nums) {
        int n = nums.length-1;
        HashSet<Integer>set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int size = set.size();
        int unique[] = new int[size];
        int i = 0;
        for(Integer element : set) {
            unique[i++] = element; 
        }
        Arrays.sort(unique);
        int ans = n;
        for(i=0; i<size; i++) {
            int num = unique[i];
            int target = num + n;
            int index = binarySearch(unique, target);
            int count = index - i +1;
            ans = Math.min(ans, n+1-count);
        }
        return ans;
    }
    
    int binarySearch(int nums[], int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = high - (high-low)/2;
            if(nums[mid]==target) {
                return mid;
            }
            if(nums[mid]>target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    
        public int minOperations1(int[] nums) {
            int n = nums.length;
            int ans = n;
            
            HashSet<Integer> unique = new HashSet<>();
            for (int num : nums) {
                unique.add(num);
            }
            
            int[] newNums = new int[unique.size()];
            int index = 0;
            
            for (int num : unique) {
                newNums[index++] = num;
            }
                
            Arrays.sort(newNums);
            
            for (int i = 0; i < newNums.length; i++) {
                int left = newNums[i];
                int right = left + n - 1;
                int j = binarySearch1(newNums, right);
                int count = j - i;
                ans = Math.min(ans, n - count);
            }
            
            return ans;
        }
        
        public int binarySearch1(int[] newNums, int target) {
            int left = 0;
            int right = newNums.length;
            
            while (left < right) {
                int mid = (left + right) / 2;
                if (target < newNums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            
            return left;
        }
        
        public int minOperations2(int[] nums) {
            int n = nums.length;
            int ans = n;
            
            HashSet<Integer> unique = new HashSet<>();
            for (int num : nums) {
                unique.add(num);
            }
            
            int[] newNums = new int[unique.size()];
            int index = 0;
            
            for (int num : unique) {
                newNums[index++] = num;
            }
                
            Arrays.sort(newNums);
            int N = newNums.length;
            int left = newNums[0];
            int right = left + n - 1;
            int j = 0;
            while(j<newNums.length && newNums[j]<=right) {
                j++;
            }
            ans = j;
            
            for (int i = 1; i < newNums.length; i++) {
                left = newNums[i];
                right = left + n - 1;
                while(j<newNums.length && newNums[j]<=right) {
                	j++;
                }
                ans = Math.max(ans, j-i);
            }
            
            return n-ans;
        }
    

}
