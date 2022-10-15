package com.vipin.algorithms.tree;

public class SortedArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {-10,-3,0,5,9};
		sortedArrayToBST(nums, 0, 4);

	}
	
	public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        int mid = (start + end)/2;
        if(start<=end){
            TreeNode t = new TreeNode(nums[mid]);
            t.left = sortedArrayToBST(nums, start, mid-1);
            t.right = sortedArrayToBST(nums, mid+1, end); 
             return t;
        }else {
            return null;
        }
        
    }
    

}
