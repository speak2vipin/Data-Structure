package com.vipin.algorithm.trie;

public class MaximumPairOfXORInIntArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TrieNode {
	TrieNode children[];

	TrieNode() {
		children = new TrieNode[2];
	}

}

	public int solve(int[] A) {
		TrieNode dummy = new TrieNode();
		int msbsize = findmsbsize(A);
// Build Trie DS
		for (int i = 0; i < A.length; i++) {
			createTrie(dummy, A[i], msbsize);
		}
		int ans = -1;
		for (int i = 0; i < A.length; i++) {
			ans = Math.max(ans, max_XOR(dummy, A[i], msbsize));
		}
		return ans;
	}

	private int findmsbsize(int[] arr) {
		int maxnum = findMaxNum(arr);
		int bit = 0;
		while (maxnum > 0) {
			maxnum = maxnum / 2;
			bit++;
		}
		return bit;
	}

	private int findMaxNum(int[] arr) {
		int ans = -1;

		for (int i = 0; i < arr.length; i++) {
			ans = Math.max(ans, arr[i]);
		}
		return ans;
	}

	private void createTrie(TrieNode root, int num, int bit) {
		TrieNode curr = root;

		for (int j = bit; j >= 0; j--) {
			int n = num;
			n = (n >> j) & 1;
			if (curr.children[n] == null) {
				curr.children[n] = new TrieNode();
			}
			curr = curr.children[n];
		}
		return;
	}

	private int max_XOR(TrieNode root, int num, int bit) {
		int xor = 0;
		TrieNode curr = root;

		for (int i = bit; i >= 0; i--) {
			int n = num;
			n = (n >> i) & 1;
			if (n == 0) {
				if (curr.children[1] != null) {
					curr = curr.children[1];
					xor = xor | (1 << i);
				} else {
					curr = curr.children[0];
				}
			} else {
				if (curr.children[0] != null) {
					curr = curr.children[0];
					xor = xor | (1 << i);
				} else {
					curr = curr.children[1];
				}
			}
		}
		return xor;
	}
}
