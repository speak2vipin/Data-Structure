package com.vipin.algorithm.linkedlist;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l6 = new ListNode(6);
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		ReorderList r = new ReorderList();
		r.reorderList(l1);
 	}

	ListNode slow = null;
	ListNode fast = null;
	ListNode prev = null;
	boolean flag = false;

	public ListNode reorderList(ListNode A) {
		if(A.next==null || A.next.next==null) {
			return A;
		}
		slow = A;
		fast = A.next;
		midElement(A);
		ListNode back = null;
		ListNode front = null;
		if (flag) {
			front = slow.next.next;
			slow.next.next = null;
			while (prev != null) {
				back = prev;
				prev = prev.next;
				back.next = front;
				front = front.next;
				back.next.next = slow;
				slow = back;
			}
		} else {

			front = slow.next;
			slow.next = null;

			while (prev != null) {
				back = prev;
				prev = prev.next;
				back.next = front;
				front = front.next;
				back.next.next = slow;
				slow = back;
			}
		}
		return back;

	}

	void midElement(ListNode A) {
		int count = 1;
		ListNode curr = null;
		while (fast != null && fast.next != null) {
			curr = slow;
			slow = slow.next;
			fast = fast.next.next;
			count = count + 2;
			curr.next = prev;
			prev = curr;
		}
		if (fast != null && fast.next == null) {
			count += 1;
		}
		flag = (count % 2 == 0);
	}

}
