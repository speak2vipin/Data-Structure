package com.vipin.algorithms.linkedlist;

public class LinkedlIstReverseWithRange {

	ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode temp = head;
		ListNode prev = null;
		ListNode leftI = null;
		ListNode rightI = null;
		ListNode fake = null;
		if (left == right) {
			return head;
		}
		int count = 0;
		while (temp != null && count < left) {
			leftI = prev;
			prev = temp;
			rightI = prev;
			temp = temp.next;
			count++;
		}
		while (temp != null && count < right) {
			fake = prev;
			prev = temp;
			temp = temp.next;
			prev.next = fake;
			count++;
		}
		if(leftI!=null)
			leftI.next = prev;
		if(temp!=null)
			rightI.next = temp;
		return head;
	}
}
