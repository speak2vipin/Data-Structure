package com.vipin.algorithm.linkedlist;

public class OrderInPartitions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode l6 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(4);
		ListNode l1 = new ListNode(1);
		l5.next = l6;
		l4.next = l5;
		l3.next = l4;
		l2.next = l3;
		l1.next = l2;
		
		ListNode l7 = new ListNode(3);
		ListNode l8 = new ListNode(1);
		ListNode l9 = new ListNode(2);
		l7.next = l8;
		l8.next = l9;
		ListNode ans = partition(l7, 3);
		System.out.println("Successful!!!");
	}

	public static ListNode partition(ListNode head, int x) {
		ListNode prev = null;
		ListNode last = null;
		ListNode curr = head;
		ListNode tempPrev = null;
		ListNode tempLast = null;
		boolean isEqual = false;
		boolean isGreater = false;

		while (curr != null) {
			if (curr.val == x) {
				if (!isEqual && !isGreater) {
					prev = tempPrev;
					isEqual = true;
				}
			} else if (curr.val > x) {
				if(!isEqual && !isGreater) {
					last = tempPrev;
					isGreater = true;
				}
			} else {
				if (isGreater) {
					ListNode temp = curr;
					if (tempPrev != null) {
						tempPrev.next = curr.next;
					}
					if (last == null) {
						curr = curr.next;
						temp.next = head;
						head = temp;
						last = temp;
						continue;
					} else {
						temp.next = last.next;
						last.next = temp;
						last = last.next;
					}

				} else if (isEqual) {
					ListNode temp = curr;
					if (tempPrev != null) {
						tempPrev.next = curr.next;
					}
					if (prev == null) {
						curr = curr.next;
						temp.next = head;
						head = temp;
						prev = temp;
						continue;
					} else {
						temp.next = prev.next;
						prev.next = temp;
						prev = prev.next;
					}
				}
			}
			tempLast = tempPrev;
			tempPrev = curr;
			curr = curr.next;

		}
		return head;
	}

}
