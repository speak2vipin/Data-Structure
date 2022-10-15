package com.vipin.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListComponent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode listNode1 = new ListNode(4);
		//ListNode listNode2 = new ListNode(3, listNode1);
		ListNode listNode2 = new ListNode(3);
		ListNode listNode3 = new ListNode(2, listNode2);
		ListNode listNode4 = new ListNode(1, listNode3);
		ListNode listNode5 = new ListNode(0, listNode4);
		//int []nums = {0,3,1,4};
		int []nums = {0,1,3};
		System.out.println(numComponents(null));
		
		
	}

	public static int numComponents(ListNode head) {
		String numsString = "";
		String input = "";
		ListNode temp = head;
		int count = 0;
		int[]nums = {3,5,12,7,4,11,16,17,6,8,15,13,19,2,14,18,9,1,10,0};
		int []numsD = {5,15,13,2,8,11,12,1,7,3,17,19,6,0,4,14};
		List<Integer> inputL = new ArrayList<Integer>();
		List<Integer> numberL = new ArrayList<Integer>();
        while(temp!=null) {
        	inputL.add(temp.val);
        	temp = temp.next;
        }
		for (int i = 0; i < nums.length; i++) {
			numberL.add(nums[i]);
		}
		for (int i = 0; i < numsD.length; i++) {
			inputL.add(numsD[i]);
		}
		
				
		boolean flag = false;
		for (int j = 0; j < numberL.size(); j++) {
			if (flag && inputL.contains(numberL.get(j))) {
				continue;
			} else if (flag && !inputL.contains(numberL.get(j))) {
				flag = false;
				count++;
			} else if (inputL.contains(numberL.get(j))) {
				flag = true;
			}
		}
		if(flag) {
			count++;
		}
		return count;
	}
	
	public ListNode swapPairs(ListNode head) {
		ListNode temp = head;
		ListNode prev = null;
		ListNode pred = null;
		int count = 0;
		prev = temp;
		ListNode arb = null;
		temp = temp.next;
		while (temp != null) {
			pred = temp.next;
			temp.next = prev;
			prev.next = pred;

			if (count == 0) {
				head = temp;
				count++;
			}
			if(arb!=null) {
				arb.next = temp;
			}
			arb = prev;
			if (pred != null) {
               prev = pred;
               temp = pred.next;
			}
			else {
				temp = pred;
			}
		}
		return head;

	}
	
	

}
