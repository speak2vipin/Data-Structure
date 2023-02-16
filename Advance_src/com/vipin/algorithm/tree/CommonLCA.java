package com.vipin.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

public class CommonLCA {

	Map<Integer, Time> map = new HashMap<Integer, Time>();
	int initial = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode t20 = new TreeNode(20);
		TreeNode t12 = new TreeNode(12);
		TreeNode t34 = new TreeNode(34);
		TreeNode t6 = new TreeNode(6);
		
		TreeNode t18 = new TreeNode(18);
		
		TreeNode t30 = new TreeNode(30);
		TreeNode t21 = new TreeNode(21);
		t20.left = t12;
		t20.right = t34;
		t12.left = t6;
		t12.right = t18;
		t34.left = t30;
		t34.right = t21;
		CommonLCA c = new CommonLCA();
		System.out.println(c.lca(t20, 34, 18));;

	}
	
	
    public int lca(TreeNode A, int B, int C) {
        int LCA = -1;
        if(A==null) {
            return -1;
        }
        TreeNode root = A;
        traversing(root);
        root = A;
        while(root!=null) {
            if(root.left != null 
                && map.get(root.left.val).entry < map.get(B).entry
                && map.get(root.left.val).entry < map.get(C).entry 
                && map.get(root.left.val).exit > map.get(B).exit
                && map.get(root.left.val).exit > map.get(C).exit ) {
                    root = root.left;
                }
                else if(root.right != null 
                    && map.get(root.right.val).entry < map.get(B).entry
                && map.get(root.right.val).entry < map.get(C).entry 
                && map.get(root.right.val).exit > map.get(B).exit
                && map.get(root.right.val).exit > map.get(C).exit ) {
                    root = root.right;
                } 
                else {
                    LCA = root.val;
                    break;
                }
        }
        return LCA;
    }

    void traversing(TreeNode root) {
        if(root==null) {
            return;
        }
        if(map.get(root.val)==null) {
            map.put(root.val, new Time(++initial, -1));
        } else {
            map.get(root.val).entry = ++initial;
        }
        traversing(root.left);
        traversing(root.right);
        
        map.get(root.val).exit = ++initial;
    }


}

class Time {
    int entry;
    int exit;

    public Time(int entry, int exit) {
        this.entry = entry;
        this.exit = exit;
    }


}
