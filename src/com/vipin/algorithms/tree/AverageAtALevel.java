package com.vipin.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageAtALevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1+' ');
	}

	public List<Double> averageOfLevels(TreeNode root) {

		List<Double> list = new ArrayList<Double>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		Double sum = 0.0;
		double average;
		while (!q.isEmpty()) {
			int count = 0;
			for (int i = 0; i < q.size(); i++) {
				TreeNode temp = q.poll();
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.left);
				}
				sum += temp.val;
				count++;
			}
			average = sum / count;
			list.add(average);
		}
		return list;
	}
}
