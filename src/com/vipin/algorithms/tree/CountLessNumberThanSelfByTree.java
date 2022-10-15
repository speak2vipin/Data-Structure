package com.vipin.algorithms.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountLessNumberThanSelfByTree {
	static Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,2,1,6};
		countSmaller(nums);
		
	}

	public static List<Integer> countSmaller(int[] nums) {
		TreeNode root = null;
        List<Integer> resultList = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (root == null) {
				root = new TreeNode(nums[i]);
			} else {
				createBST(root, nums[i], i);
			}
		}
		for(Integer val : resultMap.values()) {
            resultList.add(val);
        }
        resultList.add(0);
        return resultList;
	}

		static void createBST(TreeNode root, int input, int count) {
		boolean flag = true;
        int i = 0;
		while (count > 0) {
			if (root.val > input) {
				if (root.left != null) {
					root = root.left;
				} else if(root.right != null) {
					root = root.right;
				} else {
					root.left = new TreeNode(input);
                    //resultMap.put(resultMap.size()+1,0);
				}
				if(resultMap.get(i)!=null)
					resultMap.put(i, resultMap.get(i) + 1);
				else {
					resultMap.put(i, 1);
                }
			} else if(root.val < input) {
				if (root.left != null) {
					root = root.left;
				} else if(root.right != null) {
					root = root.right;
				} else {
					root.right = new TreeNode(input);
					resultMap.put(i, 0);
				}  
			}
            count--;
            i++;
		}
	}
    
		
	

}

/*class TreeNode {

	int val;
	TreeNode right;
	TreeNode left;

	public TreeNode(int val) {
		this.val = val;
	}
}*/
