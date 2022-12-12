package com.vipin.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[1,1,1,2,3]
		ListNode listNode1 = new ListNode(3);
		ListNode listNode2 = new ListNode(2, listNode1);
		ListNode listNode3 = new ListNode(1, listNode2);
		ListNode listNode4 = new ListNode(1, listNode3);
		ListNode listNode5 = new ListNode(1, listNode4);
		deleteDuplicates(listNode5);
	}

	public static ListNode deleteDuplicates(ListNode head) {
		List<Integer> nodeVal = new ArrayList<Integer>();
		List<Integer> duplicateVal = new ArrayList<Integer>();
		ListNode temp = head;
		ListNode prev = null;
		while (temp != null) {
			if (!nodeVal.contains(temp.val)) {
				nodeVal.add(temp.val);
			} else {
				duplicateVal.add(temp.val);
			}
			temp = temp.next;
		}
		temp = head;
		while (temp!=null) {
			if (!duplicateVal.contains(temp.val)) {
				if (prev == null) {
					prev = temp;
				} else {
					prev.next = temp;
					prev = temp;
				}
				temp = temp.next;
			} else {
				// Need to take care when duplicates is at starting
				if(prev==null) {
					head = head.next;
				}
				temp = temp.next;
			}
		}
		// Need to take care if duplicates is at corners
		if(prev!=null)
			prev.next = null;
		return head;

	}

}
