package com.vipin.algorithm.linkedlist;

public class LongestPalindromeInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromeInList l = new LongestPalindromeInList();
		ListNode l10 = new ListNode(2);
		ListNode l9 = new ListNode(2, l10);
		ListNode l8 = new ListNode(3, l9);
		ListNode l7 = new ListNode(1, l8);
		ListNode l6 = new ListNode(2, l7);
		ListNode l5 = new ListNode(2, l6);
		ListNode l4 = new ListNode(1, l5);
		ListNode l3 = new ListNode(2, l4);
		ListNode l2= new ListNode(1, l3);
		ListNode l1 = new ListNode(2, l2);
		System.out.println(l.solve(l1));

	}

	public int solve(ListNode A) {
		int len = 1;
		ListNode curr = null;
		ListNode prev = null;
		ListNode temp;
		while (A != null) {
			curr = A;
			A = A.next;
			curr.next = prev;
			prev = curr;
			temp = A;
			int evenLength =  match(curr, temp);
			if(evenLength!=0) {
				len = Math.max(evenLength, len);
			}
			if (A!=null && A.next != null) {
				int oddLength = match(curr, A.next);
				if(oddLength!=0)
					len = Math.max(oddLength + 1, len);
			}
		}
		return len;

	}

	int match(ListNode forward, ListNode backward) {
		int count = 0;
		while (forward != null && backward != null && forward.val == backward.val) {
			forward = forward.next;
			backward = backward.next;
			count += 2;
		}
		return count;

	}

}
