package com.vipin.algorithms.tree;

import java.util.HashMap;
import java.util.Map;

public class MaximumZigZagPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		t1.right = t2;
		t2.left = t3;
		t2.right = t4;
		t4.left = t5;
		t4.right = t6;
		t5.right = t7;
		t7.right = t8;

		MaximumZigZagPath m = new MaximumZigZagPath();
		System.out.println(m.helper(t1));

		int A[] = { 13, -25, 9, -27, -5, -23, 19, 1, -21, 25, 15, -29, -3, 21, 3, 23, -15, -17, -1, 0, -19, -11, -9, -7,
				5, 17, -13, 11, 27, 7 };
		int B[] = { 1, -1 };
		System.out.println(m.solve(B));

		int X[] = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
		int t = 2;
		System.out.println(m.numberOfSubarrays(X, t));
	}

	int helper(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return 0;
		}

		return Math.max(maxLen(root.left, true), maxLen(root.right, false)) + 1;
	}

	int maxLen(TreeNode root, boolean left) {
		int leftLen = 0;
		int rightLen = 0;

		if (root == null) {
			return 0;
		}
		if (left) {
			leftLen = maxLen(root.left, left);
			if (root.right != null) {
				leftLen = Math.max(leftLen, maxLen(root.right, !left) + 1);
			}
		} else {
			rightLen = maxLen(root.right, left);
			if (root.left != null) {
				rightLen = Math.max(rightLen, maxLen(root.left, !left) + 1);
			}
		}
		return Math.max(leftLen, rightLen);

	}

	public int solve(int[] A) {

		Map<Integer, Integer> map = new HashMap<>();
		int N = A.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					int val = (A[i] * A[j]) + A[k];
					map.put(val, map.getOrDefault(val, 0) + 1);
				}
			}
		}
		int mod = 1000000007;
		long ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					int val = (A[i] + A[j]) * 1 * A[k];
					if (A[k] != 0 && map.get(val) != null) {
						ans = (ans % mod + map.get(val) % mod) % mod;
					}
				}
			}
		}
		return (int) ans;

	}

	public int numberOfSubarrays(int[] nums, int k) {
		int N = nums.length;
		int i = 0, j = 0;
		int odd = 0;
		int total = 0;
		int prefix = 0;
		while (j < N) {
			if ((nums[j] % 2) != 0) {
				odd++;
				prefix = 0;
			}
			while (odd == k && i <= j) {
				if ((nums[i] % 2) != 0) {
					odd--;
				}
				i++;
				prefix++;
			}
			total += prefix;
			j++;
		}

		return total;
	}

}
