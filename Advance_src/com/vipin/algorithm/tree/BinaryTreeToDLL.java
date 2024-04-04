package com.vipin.algorithm.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BinaryTreeToDLL {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		BinaryTreeToDLL b = new BinaryTreeToDLL();
		//b.bTreeToClist(root);
		int []nums = {352171103,442454244,42644624,152727101,413370302,293999243};
		System.out.println(b.countNicePairs(nums));
		
				
	}

	TreeNode head, temp = null;

	TreeNode bTreeToClist(TreeNode root) {
		// your code here
		helper(root);
		return head;
	}

	void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root.left);

		if (head == null) {
			head = root;
			temp = root;
		} else {
			temp.right = root;
			root.left = temp;
			temp = temp.right;
		}

		helper(root.right);
	}
	
	public int reductionOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)->y-x);
        int n = nums.length;
        for(int num : nums) {
            pq.offer(num);
        }
        int temp = 0;
        int count = 0;
        while(!pq.isEmpty()) {
            int max = pq.poll();
            temp++;
            while(!pq.isEmpty() && max==pq.peek()) {
                temp++;
            }
            if(pq.isEmpty()) {
                return count;
            }
            count += temp;
        }
        return count;
    }
	
	 public int countNicePairs(int[] nums) {
	        int count = 0;
	        int n = nums.length;
	        Map<Long, Long> temp = new HashMap<>();
	        for(int i=0; i<n; i++) {
	            long reverse = findReverse(nums[i]);
	            long sum = nums[i]-reverse;
	            count = (int)((count + temp.getOrDefault(sum, 0l))%1000_000_007);
	            temp.put(sum, temp.getOrDefault(sum, 0l)+1);
	        }
	        return count;
	    }
	    
	    long findReverse(int num) { //442454244
	        StringBuffer sb = new StringBuffer();
	        sb.append(num);
	        return Long.parseLong(sb.reverse().toString());
	    }
}
