package com.vipin.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class AlternateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 1, 1, 1, 1, 0, 1 };
		int B = 0;
		System.out.println(solve(A, B));
	}

	public static int[] solve(int[] A, int B) {
		int count = 0;
		int N = A.length;
		int len = 2 * B + 1;
		int[] output = new int[N - B + 1];
		boolean flagZero = false;
		boolean flagOne = false;
		for (int l = 0; l < N - len + 1; l++) {
			flagZero = false;
			flagOne = false;
			for (int m = 0; m < len; m++) {
				if (A[m + l] == 0 && !flagZero) {
					flagZero = true;
					flagOne = false;
				} else if (A[m + l] == 1 && !flagOne) {
					flagOne = true;
					flagZero = false;
				} else {
					break;
				}
				if (m == len - 1) {
					if (B == 0) {
						output[count] = l;
					} else {
						output[count] = (l + l + len - 1) / 2;
					}
					count++;
				}

			}
		}
		int[] Ans = new int[count];
		System.arraycopy(output, 0, Ans, 0, count);
		return Ans;
	}

	public int solve(int A) {
        int ans=0,x=1;
        while(A>0){
            x*=5;
            if((A&1)==1){
                ans+=x;
            }
            A=A>>1;
        }
        return ans;
    }
}

class Solution { 
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        
        int answer = dfs(0, -1, arr1, arr2);
        
        return answer < 2_001 ? answer : -1;
    }
    
    Map<Pair<Integer, Integer>, Integer> dp = new HashMap<>();
    private int dfs(int i, int prev, int[] arr1, int[] arr2) {
        if (i == arr1.length) {
            return 0;
        }
        if (dp.containsKey(new Pair<>(i, prev))) {
            return dp.get(new Pair<>(i, prev));
        }

        int cost = 2_001;

        // If arr1[i] is already greater than prev, we can leave it be.
        if (arr1[i] > prev) {
            cost = dfs(i + 1, arr1[i], arr1, arr2);
        }

        // Find a replacement with the smallest value in arr2.
        int idx = bisectRight(arr2, prev);

        // Replace arr1[i], with a cost of 1 operation.
        if (idx < arr2.length) {
            cost = Math.min(cost, 1 + dfs(i + 1, arr2[idx], arr1, arr2));
        }

        dp.put(new Pair<>(i, prev), cost);
        return cost;
    }
    
    public int[] primesum(int A) {
        boolean [] sieve = new boolean [A+1]; // creating A+1 because index starts with 0
        Arrays.fill(sieve, true); // fill all the index with true first

         // wkt 0 and 1 were not prime numbers
        sieve[0] = false; sieve[1] = false;

        //create sieve Array (only prime numberth index will be true rest all false)
        for(int i=2; i<sieve.length; i++)
        {
            if(sieve[i])
            {
                for(int j = 2*i; j<sieve.length; j+=i)
                sieve[j] = false;
            }
        }

        int[] ans = new int [2];

        // iterate from 1 to A and checking (i and A-i) because (i + A-i) gives A;
        for(int i=1; i<A; i++)
        {
           if(sieve[i] && sieve[A-i]) {  
               ans[0] = i;
               ans[1] = A-i;
               break;
           }
        }
        return ans;
    }
    
    ListNode merge(ListNode a, ListNode b){
        ListNode temp = new ListNode(0);
        ListNode res= temp;
        while(a!=null && b!=null){
            if(a.val < b.val){
                temp.down= a;
                temp = temp.down;
                a= a.down;
            }else{
                temp.down= b;
                temp = temp.down;
                b= b.down;
            }
        }
        if(a!=null)
        temp.down =a;
        else
        temp.down=b;
        return res.down;
    }
    ListNode flatten(ListNode root) {
        if(root==null || root.right==null) {
            return root;
        }
        root.right = flatten(root.right);
        root = merge(root, root.right);
        return root;
    
    
    private static int bisectRight(int[] arr, int value) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    } 
    
    class Solution {
        int[][] dp;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int mod = 1_000_000_007;
        
        int dfs(int[][] grid, int i, int j) {
            // If dp[i][j] is non-zero, it means we have got the value of dfs(i, j),
            // so just return dp[i][j].
            if (dp[i][j] != 0)
                return dp[i][j];

            // Otherwise, set answer = 1, the path made of grid[i][j] itself.
            int answer = 1;

            // Check its four neighbor cells, if a neighbor cell grid[prevI][prevJ] has a
            // smaller value, we move to this cell and solve the subproblem: dfs(prevI, prevJ).
            for (int[] d : directions) {
                int prevI = i + d[0], prevJ = j + d[1];
                if (0 <= prevI && prevI < grid.length && 0 <= prevJ && 
                    prevJ < grid[0].length && grid[prevI][prevJ] < grid[i][j]) {
                    answer += dfs(grid, prevI, prevJ);
                    answer %= mod;
                }
            }

            // Update dp[i][j], so that we don't recalculate its value later.
            dp[i][j] = answer;
            return answer;
        }
        
        public int countPaths(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            dp = new int[m][n];

            // Iterate over all cells grid[i][j] and sum over dfs(i, j).
            int answer = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    answer = (answer + dfs(grid, i, j)) % mod;
                }
            }

            return answer;
        }
    }
}
