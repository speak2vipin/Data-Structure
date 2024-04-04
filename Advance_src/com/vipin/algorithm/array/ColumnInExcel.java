package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColumnInExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 943566;
		System.out.println(convertToTitle(A));
		int x[][] = {{0,1,0,1},
				{0,0,1,0},{1,0,1,1}};
		ColumnInExcel c = new ColumnInExcel();
		//System.out.println(c.solve(x));
		
		int a[] = {9,9,12,28,17,30,23,13,8};
		int b[] = {28,16,16,21,18,19,9,7,21,2,7,4,29,8,12,3,28,30};
		//System.out.println(solve(a, b));
		
		int nums[] = {10,1,2,7,1,3}; int  p = 2;
		System.out.println(c.minimizeMax(nums, p));
		
	}

	static public String convertToTitle(int A) {
		String res = "";
		while (A > 0) {
			int mod = (A) % 26;
			A = A / 26;
			if (mod != 0)
				res = (char) (mod + 64) + res;
			else
				res = 'Z' + res;
		}
		return res;
	}

	public int solve(int[][] A) {
		int m = A.length;
		int n = A[0].length;
		List<Integer> track[][] = new List[m][n];
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (A[i][j] == 1) {
					if (track[i][j] == null) {
						track[i][j] = new ArrayList<Integer>();
					}
					int horizontal = horizontal(A, i, j, track);
					int vertical = vertical(A, i, j, track);
					int cross = cross(A, i, j, track);
					int oppositeCross = oppositeCross(A, i, j, track);
					res = Math.max(res, Math.max(Math.max(Math.max(horizontal, vertical), cross), oppositeCross));
				}
			}
		}
		return res;

	}

	int horizontal(int[][] A, int i, int j, List<Integer> track[][]) {
		int n = A[0].length;
		int count = 0;
		while (j < n && A[i][j] == 1 && !track[i][j].contains(2)) {
			
			track[i][j].add(2);
			count++;
			j++;
			if (j < n && track[i][j] == null) {
				track[i][j] = new ArrayList<Integer>();
			}
		}
		return count;
	}

	int vertical(int[][] A, int i, int j, List<Integer> track[][]) {
		int m = A.length;
		int count = 0;
		while (i < m && A[i][j] != 0 && A[i][j] == 1 && !track[i][j].contains(3)) {
			
			track[i][j].add(3);
			count++;
			i++;
			if (i < m  && track[i][j] == null) {
				track[i][j] = new ArrayList<Integer>();
			}
		}
		return count;
	}

	int cross(int[][] A, int i, int j, List<Integer> track[][]) {
		int m = A.length;
		int n = A[0].length;
		int count = 0;
		while (i < m && j < n && A[i][j] == 1 && !track[i][j].contains(4)) {
			
			track[i][j].add(4);
			count++;
			i++;
			j++;
			if (i < m && j < n && track[i][j] == null) {
				track[i][j] = new ArrayList<Integer>();
			}
		}
		return count;
	}

	int oppositeCross(int[][] A, int i, int j, List<Integer> track[][]) {
		int m = A.length;
		int n = A[0].length;
		int count = 0;
		while (i < m && j > -1 && A[i][j] == 1 && !track[i][j].contains(5)) {
			
			track[i][j].add(5);
			count++;
			i++;
			j--;
			if (i < m && j > -1 && track[i][j] == null) {
				track[i][j] = new ArrayList<Integer>();
			}
		}
		return count;
	}
	
	public static int solve(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int mod = 1000_000_007;
        int temp[][] = new int[n][m];
        int count = 0;
        for(int i=0; i<m; i++) {
            int val = A[i];
            for(int j=0; j<n; j++) {
                if(i!=m-1) {
                    temp[i][j] = val; 
                } else {
                    temp[i][j] = B[j];
                }
                count = (count + temp[i][j])%mod;
            }
        }
        return count;
    }
	
public int minimizeMax(int[] nums, int p) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n-1] - nums[0];
        while(left<=right) {
            int mid = left + (right-left)/2;
            int validPairs = countValidPairs(nums, mid);
            int validPairsNext = countValidPairs(nums, mid+1);
            if((validPairs >= p) && (validPairsNext<p)) {
                return mid;
            }
            if(validPairs>p) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        return -1;
        
    }
    
    int countValidPairs(int nums[], int mid) {
        int count = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]-nums[i-1]<=mid) {
                count++;
            }
        }
        return count;
    }

}
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        int end = n - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (!isBinarySearchHelpful(nums, start, nums[mid])) {
                start++;
                continue;
            }
            // which array does pivot belong to.
            boolean pivotArray = existsInFirst(nums, start, nums[mid]);

            // which array does target belong to.
            boolean targetArray = existsInFirst(nums, start, target);
            if (pivotArray ^ targetArray) { // If pivot and target exist in different sorted arrays, recall that xor is true when both operands are distinct
                if (pivotArray) {
                    start = mid + 1; // pivot in the first, target in the second
                } else {
                    end = mid - 1; // target in the first, pivot in the second
                }
            } else { // If pivot and target exist in same sorted array
                if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    // returns true if we can reduce the search space in current binary search space
    private boolean isBinarySearchHelpful(int[] arr, int start, int element) {
        return arr[start] != element;
    }

    // returns true if element exists in first array, false if it exists in second
    private boolean existsInFirst(int[] arr, int start, int element) {
        return arr[start] <= element;
    }
}